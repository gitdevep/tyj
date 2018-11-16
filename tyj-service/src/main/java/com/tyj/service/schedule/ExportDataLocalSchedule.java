/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.MapUtils;
import com.google.common.collect.Lists;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosActive;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosCount;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.taskStatus.bo.TaskStatus;
import com.tyj.dao.demo.vo.FirstCondition;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosActiveService;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosCountService;
import com.tyj.service.demo.general.DeviceInfoService;
import com.tyj.service.schedule.condition.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static cn.vansky.framework.common.util.DateUtil.MINUTE_TIME;
import static cn.vansky.framework.common.util.DateUtil.getBetweenDiff;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/12/21
 */
@Service("exportDataLocalSchedule")
public class ExportDataLocalSchedule {
    /**
     * 本地库
     */
    @Resource(name = "deviceInfoService")
    DeviceInfoService deviceInfoService;

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "deviceGpsInfosCountService")
    DeviceGpsInfosCountService deviceGpsInfosCountService;

    @Resource(name = "deviceGpsInfosActiveService")
    DeviceGpsInfosActiveService deviceGpsInfosActiveService;

    public void export() {
        export(DateUtil.getDateStr(new Date(), DateUtil.yyyy_MM_dd, Calendar.DATE, -1));
    }

    public void export(String date) {
        int COMMIT = 10;
        Date cd = DateUtil.parse(DateUtil.yyyy_MM_dd, date);
        Map<String, Object> p = MapUtils.<String, Object>build().put("startDate", date)
                .put("endDate", DateUtil.getDateStr(cd, DateUtil.yyyy_MM_dd, Calendar.DATE, 1))
                .put("systemId", TaskStatus.SYSTEM_ID).put("status", TaskStatus.OVER_STATUS).get();
        List<DeviceInfo> ds = deviceInfoService.findAll();
        List<DeviceGpsInfosCount> l = new ArrayList<DeviceGpsInfosCount>(COMMIT);
        int i = 0;
        if (null != ds) {
            // 清洗每天设备日志，插入驾驶状态
            for (DeviceInfo d : ds) {
                ++i;
                p.put("deviceId", d.getDeviceId());
                l.add(clean(deviceGpsInfosService.findByDeviceIdAndTime(p), p));
                if (i % COMMIT == 0) {
                    deviceGpsInfosCountService.saveBatch(l);
                    l = new ArrayList<DeviceGpsInfosCount>(COMMIT);
                }
            }
            if (!l.isEmpty()) {
                deviceGpsInfosCountService.saveBatch(l);
            }
        }
    }

    public DeviceGpsInfosCount clean(List<DeviceGpsInfos> list, Map<String, Object> p) {
        List<FirstCondition> l = Lists.newArrayList();
        FirstCondition pre = null;
        FirstCondition next = null;
        boolean first = true;
        for (DeviceGpsInfos c : list) {
            // 从第一汽车启动算开始，前面的不算了
            if (first && MsgType.CAR_START.getMsgType() == c.getMsgType().intValue()) {
                pre = new FirstCondition();
                pre.setCarStart(c);
                first = false;
            } else if (!first) {
                if (MsgType.CAR_START.getMsgType() == c.getMsgType().intValue()) {
                    if (null == pre.getCarStart()) {
                        pre.setCarStart(c);
                    } else {
                        pre.addDeviceGpsInfos(c);

                    }
                    continue;
                }
                if (MsgType.CAR_END.getMsgType() == c.getMsgType().intValue()) {
                    if (null == pre.getCarStart()) {
                        // 熄火后面跟着熄火，取出前一个熄火放入前一个区间
                        pre.getPre().addDeviceGpsInfos(pre.getPre().getCarEnd());
                        // 前一个熄火被当前的替换
                        pre.getPre().setCarEnd(c);
                    } else {
                        pre.setCarEnd(c);
                        next = new FirstCondition();
                        pre.setNext(next);
                        l.add(pre);
                        next.setPre(pre);
                        pre = next;
                    }
                    continue;
                }
                if (null != pre.getCarStart()) {
                    if (null == pre.getCarEnd()) {
                        pre.addDeviceGpsInfos(c);
                    }
                } else {
                    // four 连续三个消息ID信息是熄火、定位、启动，那么该定位一般与上条熄火时间一致，算作上一次行车区间
                    // 熄火后面跟的告警信息，全部算上一次
                    pre.getPre().addDeviceGpsInfos(c);
                }
            }
        }

        double dt = 0.0;
        list = new ArrayList<DeviceGpsInfos>(list.size());
        for (FirstCondition c : l) {
            List<DeviceGpsInfos> li = c.deal();
            if (null == li) {
                continue;
            }
            list.addAll(li);
            dt+= getBetweenDiff(c.getCarStart().getEventTime(), c.getCarEnd().getEventTime(), MINUTE_TIME);
        }
        int COMMIT = 500;
        List<DeviceGpsInfosActive> actives = new ArrayList<DeviceGpsInfosActive>(COMMIT);
        int i = 0;
        for (DeviceGpsInfos d : list) {
            i++;
            DeviceGpsInfosActive active =  new DeviceGpsInfosActive();
            BeanUtils.copyProperties(d, active);
            actives.add(active);
            if (i % COMMIT == 0) {
                deviceGpsInfosActiveService.saveBatch(actives);
                actives = new ArrayList<DeviceGpsInfosActive>(COMMIT);
            }
        }
        if (!actives.isEmpty()) {
            deviceGpsInfosActiveService.saveBatch(actives);
        }
        DeviceGpsInfosCount g = calculateDeviceGpsCount(list);
        g.setDriveTime(dt);
        g.setDeviceId((Integer) p.get("deviceId"));
        g.setCountDate(DateUtil.parse(DateUtil.yyyy_MM_dd, p.get("startDate").toString()));
        calculateScore(list, g);
        return g;
    }

    public DeviceGpsInfosCount calculateDeviceGpsCount(List<DeviceGpsInfos> list) {
        DeviceGpsInfosCount g = new DeviceGpsInfosCount();
        DeviceGpsInfos f = null;
        DeviceGpsInfos bak = null;
        int index = 0;
        for (DeviceGpsInfos d : list) {
            String m = MsgType.getProperty(d.getMsgType().intValue());
            if (MsgType.COLLIDE_FOLLOW.getProperty().equals(m)) {
                if (index == 0) {
                    bak = f;
                }
                if (MsgType.CAR_FRONT_COLLIDE.getMsgType() == bak.getMsgType().intValue()) {
                    g.setCarCollideFollow(g.getCarCollideFollow() + 1);
                } else if (MsgType.PERSON_FRONT_COLLIDE.getMsgType() == bak.getMsgType().intValue()) {
                    g.setPersonCollideFollow(g.getPersonCollideFollow() + 1);
                }
                index++;
            } else if (MsgType.CITY_FRONT_COLLIDE.getMsgType() == d.getMsgType().intValue()) {
                if (d.getSpeed() == 0) {
                    g.setCityFrontCollide(g.getCityFrontCollide() + 1);
                }
                if (d.getSpeed() < 30) {
                    g.setOneCarFrontCollide(g.getOneCarFrontCollide() + 1);
                } else {
                    g.setTwoCarFrontCollide(g.getTwoCarFrontCollide() + 1);
                }
                index = 0;
                continue;
            } else if (MsgType.CAR_FRONT_COLLIDE.getMsgType() == d.getMsgType().intValue()) {
                if (d.getSpeed() < 30) {
                    g.setOneCarFrontCollide(g.getOneCarFrontCollide() + 1);
                } else {
                    g.setTwoCarFrontCollide(g.getTwoCarFrontCollide() + 1);
                }
            } else {
                index = 0;
            }
            if (null == m) {
                continue;
            }
            PropertyDescriptor t = BeanUtils.getPropertyDescriptor(g.getClass(), m);
            try {
                Method r = t.getReadMethod();
                if (!Modifier.isPublic(r.getDeclaringClass().getModifiers())) {
                    r.setAccessible(true);
                }
                Object value = r.invoke(g);
                Method w = t.getWriteMethod();
                if (!Modifier.isPublic(w.getDeclaringClass().getModifiers())) {
                    w.setAccessible(true);
                }
                w.invoke(g, ((Integer) value + 1));
            }
            catch (Throwable e) {
                throw new FatalBeanException("Could not copy property '" + t.getName()
                        + "' from source to target", e);
            }
            f = d;
        }
        return g;
    }

    private void calculateScore(List<DeviceGpsInfos> lo, DeviceGpsInfosCount g) {
        DeviceGpsInfos front = new DeviceGpsInfos();
        RootCondition root = new RootCondition(front);
        for (DeviceGpsInfos l : lo) {
            // 速度
            SpeedCondition speedCondition = new SpeedCondition(l);
            root.addCondition(speedCondition);
            // 每天驾驶时长
            DayDriverTimeCondition dayDriverTimeCondition = new DayDriverTimeCondition(l);
            dayDriverTimeCondition.setStartDate(lo.get(0).getEventTime());
            root.addCondition(dayDriverTimeCondition);
            // 前后时间间隔
            TimeDiffCondition timeDiffCondition = new TimeDiffCondition(l);
            timeDiffCondition.setFrontDate(front.getEventTime());
            timeDiffCondition.setFrontType(front.getMsgType());
            root.addCondition(timeDiffCondition);
            // TODO 天气条件
//            WeatherCondition weatherCondition = new WeatherCondition(l, weatherHistoryService);

            // 疲劳度
            TimeFatigueCondition timeFatigueCondition = new TimeFatigueCondition(l);
            root.addCondition(timeFatigueCondition);
            // 能见度
            TimeVisibilityCondition timeVisibilityCondition = new TimeVisibilityCondition(l);
            root.addCondition(timeVisibilityCondition);
            front = l;
        }
        saveScore(root.calculateScore(), g);
    }

    private void saveScore(double sum, DeviceGpsInfosCount g) {
        g.setSum(sum);
        if (g.getDriveTime() != 0 && sum != 0) {
            double d = sum / g.getDriveTime();
            double s = 31 * Math.atan((31 - 0.9 * d) / 15) + 65.27;
            g.setScores(s);
        }
    }
}
