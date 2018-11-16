/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/17
 */
public enum MsgTypeOld {
    LEFT_LANE_DEVIATE(1, "leftLaneDepartureWarning", "左车道偏离"),
    RIGHT_LANE_DEVIATE(2, "rightLaneDepartureWarning", "右车道偏离"),
    CAR_DISTANCE_MONITOR(3, "headwayMonitoringWarning", "车距监测"),
    LIMIT_SPEED_ALARM(4, "overSpeedWarning", "限速警示"),
    CITY_FRONT_COLLIDE(5, "urbanForwardCollisionWarning", "城市前碰撞"),
    CAR_FRONT_COLLIDE(6, "forwardCollisionWarning", "车辆前部碰撞"),
            ;
    private int msgType;
    private String property;
    private String name;
    MsgTypeOld(int msgType, String property, String name) {
        this.msgType = msgType;
        this.property = property;
        this.name = name;
    }

    public static String getProperty(int type) {
        MsgTypeOld [] olds = MsgTypeOld.values();
        for (MsgTypeOld old : olds) {
            if (old.getMsgType() == type) {
                return old.getProperty();
            }
        }
        return null;
    }

    public int getMsgType() {
        return msgType;
    }

    public String getProperty() {
        return property;
    }
}
