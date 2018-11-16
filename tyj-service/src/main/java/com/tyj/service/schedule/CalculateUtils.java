/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule;

import cn.vansky.framework.common.util.AmountCountUtil;
import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.MapDistance;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.demo.vo.*;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;

import java.util.*;

import static cn.vansky.framework.common.util.DateUtil.MINUTE_TIME;
import static cn.vansky.framework.common.util.DateUtil.getBetweenDiff;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/4
 */
public class CalculateUtils {
    public static double calculateMinute(List<DeviceGpsInfos> list) {
        List<FirstCondition> l = new ArrayList<FirstCondition>();
        FirstCondition pre = new FirstCondition(), next = null;
        for (DeviceGpsInfos c : list) {
            // 前个链表中的熄火不为空，新建链表
            if (MsgType.CAR_START.getMsgType() == c.getMsgType().intValue() && pre.getCarEnd() != null) {
                // 如果为启动，新建一个链表
                pre = new FirstCondition();
                // 设置开始数据
                pre.setCarStart(c);
            } else {
                if (MsgType.CAR_START.getMsgType() == c.getMsgType().intValue()) {
                    if (pre.getCarStart() == null) {
                        // 第一条为启动信息
                        pre.setCarStart(c);
                    } else {
                        // 启动信息连续，第N次的启动算list里面
                        pre.addDeviceGpsInfos(c);
                    }
                    continue;
                } else if (MsgType.CAR_END.getMsgType() == c.getMsgType().intValue()) {
                    if (null == pre.getCarStart() && pre.getPre() != null) {
                        // 熄火后面跟着熄火，取出前一个熄火放入前一个区间
                        pre.getPre().addDeviceGpsInfos(pre.getPre().getCarEnd());
                        // 前一个熄火被当前的替换
                        pre.getPre().setCarEnd(c);
                    } else {
                        // 设置熄火信息
                        pre.setCarEnd(c);
                        // 设置下个节点
                        next = new FirstCondition();
                        pre.setNext(next);
                        l.add(pre);
                        next.setPre(pre);
                        pre = next;
                    }
                    continue;
                } else {
                    // 其他的告警信息，全部加到当前列表中
                    pre.addDeviceGpsInfos(c);
                }
            }
        }
        double dt = 0;
        for (FirstCondition c : l) {
            Date start = null, end = null;
            if (c.getCarStart() != null) {
                start = c.getCarStart().getEventTime();
            }
            if (c.getCarEnd() != null) {
                end = c.getCarEnd().getEventTime();
            }
            // 开始时间为空
            if (null == start && c.getList() != null && !c.getList().isEmpty()) {
                start = c.getList().get(0).getEventTime();
            }
            // 结束时间为空
            if (null == end && c.getList() != null && !c.getList().isEmpty()) {
                end = c.getList().get(c.getList().size() - 1).getEventTime();
            }
            if (start != null && end != null) {
                dt+= getBetweenDiff(start, end, MINUTE_TIME);
            }
        }
        return dt;
    }

    public static double calculateTime(List<DeviceGpsInfos> list) {
        double dt = calculateMinute(list);
        return AmountCountUtil.div(dt, 60);
    }

    /**
     * GPS经纬度转换，度分转换成度
     * @param d 经纬度(以度分为单位)
     * @return 经纬度(以度为单位)
     */
    public static double convertGPS(Double d) {
        return d * 100 % 100 / 60 + d.intValue();
    }

    /**
     * 计算每个类型对应的告警总量
     * @param l list
     * @return int []
     */
    public static int [] calculateTypeCount(List<DeviceGpsInfos> l) {
        int length = 9;
        int [] d = new int[length];
        for (DeviceGpsInfos g : l) {
            int index = MsgType.getIndex(g.getMsgType().intValue());
            if (index == -1) {
                continue;
            }
            if (index < length) {
                d[index]++;
            }
        }
        return d;
    }

    /**
     * 1:平均每小时告警量=单个告警总量/驾驶时长
     * 2:平均每百公里告警量=单个告警总量/总里程
     * @param d 所有类型告警总量
     * @param param 驾驶时长/km
     * @return double []
     */
    public static double [] calculateTypeCountByParam(int [] d, double param) {
        int length = d.length;
        double [] r = new double[length];
        for (int i = 0; i < length; i++) {
            if (param != 0) {
                r[i] = AmountCountUtil.div(d[i], param);
            }
        }
        return r;
    }

    /**
     * 每个类型设置相应的速度段
     * @param l list
     * @return Map<Integer, double[]>
     */
    public static Map<Integer, double[]> calculateTypeCountBySpeed(List<DeviceGpsInfos> l) {
        int length = 5;
        Map<Integer, double[]> m = new HashMap<Integer, double[]>(9);
        m.put(0, new double[length]);
        m.put(1, new double[length]);
        m.put(2, new double[length]);
        m.put(3, new double[length]);
        m.put(4, new double[length]);
        m.put(5, new double[length]);
        m.put(6, new double[length]);
        m.put(7, new double[length]);
        m.put(8, new double[length]);
        for (DeviceGpsInfos g : l) {
            // 根据下标获取对应的全部速度表
            int index = MsgType.getIndex(g.getMsgType().intValue());
            if (index == -1) {
                continue;
            }
            if (g.getSpeed() < 20) {
                m.get(index)[0]++;
            } else if (g.getSpeed() < 40) {
                m.get(index)[1]++;
            } else if (g.getSpeed() < 60) {
                m.get(index)[2]++;
            } else if (g.getSpeed() < 80) {
                m.get(index)[3]++;
            } else {
                m.get(index)[4]++;
            }
        }
        return m;
    }

    /**
     * 每个类型设置相应的时间段
     * @param l list
     * @return Map<Integer, double[]>
     */
    public static Map<Integer, double[]> calculateTypeCountByTime(List<DeviceGpsInfos> l) {
        int length = 24;
        Map<Integer, double[]> m = new HashMap<Integer, double[]>(9);
        m.put(0, new double[length]);
        m.put(1, new double[length]);
        m.put(2, new double[length]);
        m.put(3, new double[length]);
        m.put(4, new double[length]);
        m.put(5, new double[length]);
        m.put(6, new double[length]);
        m.put(7, new double[length]);
        m.put(8, new double[length]);
        for (DeviceGpsInfos g : l) {
            // 定位获取哪个类型
            int index = MsgType.getIndex(g.getMsgType().intValue());
            if (index == -1) {
                continue;
            }
            int i = Integer.parseInt(DateUtil.format(DateUtil.HH_mm, g.getEventTime()).substring(0, 2));
            m.get(index)[i]++;
        }
        return m;
    }

    /**
     * 计算每个速度下的数量
     * @param l list
     * @return double []
     */
    public static double [] calculateTypeCountByLimitSpeed(List<DeviceGpsInfos> l) {
        int length = 10;
        double [] m = new double[length];
        for (DeviceGpsInfos g : l) {
            if (MsgType.LIMIT_SPEED_ALARM.getMsgType() == g.getMsgType().intValue()) {
                if (g.getSpeed() < 5) {
                    m[0]++;
                } else if (g.getSpeed() < 20) {
                    m[1]++;
                } else if (g.getSpeed() < 30) {
                    m[2]++;
                } else if (g.getSpeed() < 40) {
                    m[3]++;
                } else if (g.getSpeed() < 50) {
                    m[4]++;
                } else if (g.getSpeed() < 60) {
                    m[5]++;
                } else if (g.getSpeed() < 70) {
                    m[6]++;
                } else if (g.getSpeed() < 80) {
                    m[7]++;
                } else if (g.getSpeed() < 100) {
                    m[8]++;
                } else {
                    m[9]++;
                }
            }
        }
        return m;
    }

    public static int [] calculateOverSpeedTime(List<DeviceGpsInfos> list) {
        int [] a = new int[OverSpeedTime.values().length];
        DeviceGpsInfos follow = null;
        DeviceGpsInfos alarm = null;
        for (DeviceGpsInfos gpsInfos : list) {
            if (gpsInfos.getMsgType().intValue() == MsgType.OVER_SPEED_ALARM.getMsgType()) {
                alarm = gpsInfos;
            }
            if (gpsInfos.getMsgType().intValue() == MsgType.OVER_SPEED_FOLLOW.getMsgType()) {
                follow = gpsInfos;
            }
            if (follow != null && alarm != null) {
                // 超速时长 = 超速跟踪 – 上条超速警示
                int second = (int) DateUtil.getBetweenDiff(alarm.getEventTime(), follow.getEventTime(),
                        DateUtil.SECOND_TIME);
                int index = OverSpeedTime.getIndex(second);
                a[index]++;
                follow = null;
                alarm = null;
            }
            if (follow != null && alarm == null) {
                follow = null;
            }
        }
        return a;
    }

    public static int [] calculateOverSpeedTimeMaxValue(List<DeviceGpsInfos> list) {
        int [] a = new int[OverSpeedMaxValue.values().length];
        DeviceGpsInfos follow = null;
        DeviceGpsInfos alarm = null;
        for (DeviceGpsInfos gpsInfos : list) {
            if (gpsInfos.getMsgType().intValue() == MsgType.OVER_SPEED_ALARM.getMsgType()) {
                alarm = gpsInfos;
            }
            if (gpsInfos.getMsgType().intValue() == MsgType.OVER_SPEED_FOLLOW.getMsgType()) {
                follow = gpsInfos;
            }
            if (follow != null && alarm != null) {
                // 最大超速值 = 超速警示和超速跟踪两条告警速度的最大值
                int max = alarm.getSpeed() > follow.getSpeed() ? alarm.getSpeed() : follow.getSpeed();
                // 限速值 = 超速警示告警该条信息内加速度的值×10
                int acceleration = (int) (alarm.getAcceleration() == null ? 0 : alarm.getAcceleration());
                int limit = acceleration * 10;
                int index = OverSpeedMaxValue.getIndex(max - limit);
                a[index]++;
                follow = null;
                alarm = null;
            }
            if (follow != null && alarm == null) {
                follow = null;
            }
        }
        return a;
    }

    public static int [] calculateOverSpeedTimeLimitValue(List<DeviceGpsInfos> list) {
        int [] a = new int[OverSpeedLimitValue.values().length];
        for (DeviceGpsInfos gpsInfos : list) {
            if (gpsInfos.getMsgType().intValue() == MsgType.OVER_SPEED_ALARM.getMsgType()) {
                // 限速值 = 超速警示告警该条信息内加速度的值×10
                int acceleration = (int) (gpsInfos.getAcceleration() == null ? 0 : gpsInfos.getAcceleration());
                int limit = acceleration * 10;
                int index = OverSpeedLimitValue.getIndex(limit);
                a[index]++;
            }
        }
        return a;
    }

    public static int [] calculateCollideSpeedValue(List<DeviceGpsInfos> list, int type) {
        int [] a = new int[PersonCollideSpeedMaxValue.values().length];
        for (DeviceGpsInfos gpsInfos : list) {
            if (gpsInfos.getMsgType().intValue() == type) {
                int index = PersonCollideSpeedMaxValue.getIndex(gpsInfos.getSpeed());
                a[index]++;
            }
        }
        return a;
    }

    /**
     * 计算告警距离
     * @param l list
     * @return double
     */
    public static double calculateDistance(List<DeviceGpsInfos> l) {
        double distance = 0;
        DeviceGpsInfos front = null;
        for (int i = 0; i < l.size(); i++) {
            DeviceGpsInfos it = l.get(i);
            if (it.getLongitude() > 0 && it.getLatitude() > 0 && front != null) {
                distance += MapDistance.getDistance(it.getLongitude(), it.getLatitude(), front.getLongitude(), front.getLatitude());
                front = it;
            } else if (it.getLongitude() > 0 && it.getLatitude() > 0) {
                front = it;
            }
        }
        return distance;
    }
}
