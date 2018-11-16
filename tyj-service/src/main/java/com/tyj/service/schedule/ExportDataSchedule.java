/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.MapUtils;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosActive;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosCount;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.vo.FirstCondition;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosActiveService;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosCountService;
import com.tyj.service.demo.general.DeviceInfoService;
import com.tyj.service.demo.taskStatus.service.TaskStatusService;
import com.tyj.service.demo.weather.service.WeatherHistoryService;
import com.tyj.service.jhpt.deviceGpsInfos.service.DeviceGpsInfosServiceJhpt;
import com.tyj.service.jhpt.deviceInfo.service.DeviceInfoServiceJhpt;
import com.tyj.service.schedule.condition.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.scheduling.annotation.Scheduled;
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
@Service("exportDataSchedule")
public class ExportDataSchedule {

    private static final Logger logger = LoggerFactory.getLogger(ExportDataSchedule.class);
    /**
     * 本地库
     */
    @Resource(name = "deviceInfoService")
    DeviceInfoService deviceInfoService;

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "taskStatusService")
    TaskStatusService taskStatusService;

    @Resource(name = "deviceGpsInfosCountService")
    DeviceGpsInfosCountService deviceGpsInfosCountService;

    /**
     * 远程库
     */
    @Resource(name = "deviceInfoServiceJhpt")
    DeviceInfoServiceJhpt deviceInfoServiceJhpt;

    @Resource(name = "deviceGpsInfosServiceJhpt")
    DeviceGpsInfosServiceJhpt deviceGpsInfosServiceJhpt;

    @Resource(name = "weatherHistoryService")
    WeatherHistoryService weatherHistoryService;

    @Resource(name = "deviceGpsInfosActiveService")
    DeviceGpsInfosActiveService deviceGpsInfosActiveService;

    @Resource(name = "exportOldDataSchedule")
    ExportOldDataSchedule exportOldDataSchedule;

    @Scheduled(cron = "0 5 0 * * ?")
    public void export() {
        export(DateUtil.getDateStr(new Date(), DateUtil.yyyy_MM_dd, Calendar.DATE, -1));
    }

    public void export(String date) {
        // 定时任务每月2号创建分区
        if ("01".equals(date.substring(date.length() - 2))) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("table_schema", "demo");
            map.put("table_name", "device_gps_infos");
            deviceGpsInfosService.createPartition(map);
        }
        int COMMIT = 10;
        Date cd = DateUtil.parse(DateUtil.yyyy_MM_dd, date);
        Map<String, Object> p = MapUtils.<String, Object>build().put("startDate", date)
                .put("endDate", DateUtil.getDateStr(cd, DateUtil.yyyy_MM_dd, Calendar.DATE, 1))
//                .put("systemId", TaskStatus.SYSTEM_ID).put("status", TaskStatus.OVER_STATUS)
                .get();
//        p.put("taskType", TaskStatus.EXPORT_DEVICE_INFO);
//        TaskStatus t = taskStatusService.findTaskStatus(p);
        List<DeviceInfo> ds = null;
//        if (t == null) {
            // 清理用户表
            deviceInfoService.truncate();
            // 远程转换成本地信息
            ds = covertDeviceInfo();
//            taskStatusService.saveEntity(addTaskStatus(p));
//            logger.info("日期[" + date + "]添加用户表ok");
//        } else {
//            // 查询本地库
//            ds = deviceInfoService.findAll();
//        }
//        p.put("taskType", TaskStatus.EXPORT_DEVICE_GPS_INFO);
//        t = taskStatusService.findTaskStatus(p);
//        if (t == null) {
//            deviceGpsInfosService.delByDeviceIdAndTime(p);
            exportInfos(deviceGpsInfosServiceJhpt.findByDeviceIdAndTime(p));
//            taskStatusService.saveEntity(addTaskStatus(p));
//            logger.info("日期[" + date + "]添加客户原始数据表ok");
//        }
//        List<TaskStatus> ts = new ArrayList<TaskStatus>(COMMIT);
        List<DeviceGpsInfosCount> l = new ArrayList<DeviceGpsInfosCount>(COMMIT);
        int i = 0;
        if (null != ds) {
            // 清洗每天设备日志，插入驾驶状态
            for (DeviceInfo d : ds) {
                ++i;
                p.put("deviceId", d.getDeviceId());
//                p.put("taskType", TaskStatus.EXPORT_DEVICE_GPS_INFO_COUNT);
//                t = taskStatusService.findTaskStatus(p);
//                if (null == t) {
//                    // 删除某个用户某天的统计数据
                    deviceGpsInfosCountService.delByDeviceIdAndTime(p);
                    l.add(clean(deviceGpsInfosService.findByDeviceIdAndTime(p), p));
//                    ts.add(addTaskStatus(p));
//                }
                if (i % COMMIT == 0) {
//                    taskStatusService.saveBatch(ts);
//                    ts = new ArrayList<TaskStatus>(COMMIT);
                    deviceGpsInfosCountService.saveBatch(l);
                    l = new ArrayList<DeviceGpsInfosCount>(COMMIT);
                }
                logger.info("日期[" + date + "]用户total["+ d.getDeviceId() + "] 执行 ok");
            }
//            if (!ts.isEmpty()) {
//                taskStatusService.saveBatch(ts);
//            }
            if (!l.isEmpty()) {
                deviceGpsInfosCountService.saveBatch(l);
            }
        }

        exportOldDataSchedule.export(date, ds);
    }

    private List<DeviceInfo> covertDeviceInfo() {
        // 从远程库获取用户所有信息
        List<com.tyj.dao.jhpt.deviceInfo.bo.DeviceInfo> ri = deviceInfoServiceJhpt.findAll();
        List<DeviceInfo> l = new ArrayList<DeviceInfo>(ri.size());
        for (com.tyj.dao.jhpt.deviceInfo.bo.DeviceInfo r : ri) {
            l.add(r.covert());
        }
        if (!l.isEmpty()) {
            deviceInfoService.saveBatch(l);
        }
        return l;
    }

    public void exportInfos(List<com.tyj.dao.jhpt.deviceGpsInfos.bo.DeviceGpsInfos> ri) {
        int i = 500;
        List<DeviceGpsInfos> l = new ArrayList<DeviceGpsInfos>(i);
        int t = 0;
        for (com.tyj.dao.jhpt.deviceGpsInfos.bo.DeviceGpsInfos r : ri) {
            ++t;
            DeviceGpsInfos front = new DeviceGpsInfos();
            BeanUtils.copyProperties(r, front);
            l.add(front);
            if (t % i == 0) {
                deviceGpsInfosService.saveBatch(l);
                l = new ArrayList<DeviceGpsInfos>(i);
            }
        }
        if (!l.isEmpty()) {
            deviceGpsInfosService.saveBatch(l);
        }
    }

    public DeviceGpsInfosCount clean(List<DeviceGpsInfos> list, Map<String, Object> p) {
        List<FirstCondition> l = new ArrayList<FirstCondition>();
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
        list = new ArrayList<DeviceGpsInfos>(list.size() << 1);
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
            actives = null;
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
            } catch (Throwable e) {
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
            double s = 31 * Math.atan((31 - 0.13 * d) / 15) + 65.27;
            g.setScores(s);
        }
    }
}
