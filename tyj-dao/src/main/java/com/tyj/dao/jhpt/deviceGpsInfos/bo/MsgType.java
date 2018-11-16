package com.tyj.dao.jhpt.deviceGpsInfos.bo;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/12/21
 */
public enum MsgType {

    LEFT_LANE_DEVIATE(1, "leftLaneDeviate", "左车道偏离", 0), // 左车道偏离
    RIGHT_LANE_DEVIATE(2, "rightLaneDeviate", "右车道偏离", 1), // 右车道偏离
    CAR_DISTANCE_MONITOR(3, "carDistanceMonitor", "车距监测", 2), // 车距监测
    LIMIT_SPEED_ALARM(4, "limitSpeedAlarm", "限速警示", 3), // 限速警示
    CITY_FRONT_COLLIDE(5, "cityFrontCollide", "城市前碰撞", 4), // 城市前碰撞
    CAR_FRONT_COLLIDE(6, "carFrontCollide", "车辆前部碰撞", 5), // 车辆前部碰撞
    CAR_START(7, "carStart", "汽车启动"), // 汽车启动
    CAR_END(8, "carEnd", "汽车熄火"), // 汽车熄火
    LOCATION_MESSAGE(9, "locationMessage", "定位信息"), // 定位信息
    SPEED_UP(13, "speedUp", "急加速", 6), // 急加速
    SPEED_DOWN(14, "speedDown", "急减速", 7),// 急减速
    VD_NO_START(15, "vdNoStart", "VD未启动"),// VD未启动
    DEVICE_ACTIVE(16, "deviceActive", "设备已激活"),// 设备已激活
    PERSON_FRONT_COLLIDE(17, "personFrontCollide", "行人前部碰撞", 8),// 行人前部碰撞
    COLLIDE_FOLLOW(18, "collideFollow", "碰撞跟踪"),// 碰撞跟踪
    DEVICE_SET_SUCCESS(19, "deviceSetSuccess", "设备配置成功"),// 设备配置成功
    DEVICE_SET_FAIL(20, "deviceSetFail", "设备配置失败"), // 设备配置失败
    OVER_SPEED_FOLLOW(21, "overSpeedFollow", "超速跟踪"), // 超速跟踪
    OVER_SPEED_ALARM(22, "overSpeedAlarm", "超速警示"), // 超速警示
    PERSON_COLLIDE_FOLLOW(23, "personCollideFollow", "行人碰撞跟踪"), // 行人碰撞跟踪
    CAR_COLLIDE_FOLLOW(50, "carCollideFollow", "车辆前部碰撞跟踪"), // 车辆前部碰撞跟踪
    PERSON_FRONT_COLLIDE_FOLLOW(51, "personFrontCollideFollow", "行人前部碰撞跟踪"),// 行人前部碰撞跟踪
    ONE_CAR_FRONT_COLLIDE(52, "oneCarFrontCollide", "一类车辆前部碰撞"),// 一类车辆前部碰撞
    TWO_CAR_FRONT_COLLIDE(53, "twoCarFrontCollide", "二类车辆前部碰撞");// 二类车辆前部碰撞

    MsgType(int msgType, String property, String name) {
        this(msgType, property, name, -1);
    }

    MsgType(int msgType, String property, String name, int index) {
        this.msgType = msgType;
        this.property = property;
        this.name = name;
        this.index = index;
    }

    private int msgType;
    private String property;
    private String name;
    private int index;

    public static String getProperty(int msgType) {
        MsgType [] types = MsgType.values();
        for (MsgType type : types) {
            if (type.getMsgType() == msgType) {
                return type.getProperty();
            }
        }
        return null;
    }

    public static int getMsgType(String name) {
        MsgType [] types = MsgType.values();
        for (MsgType type : types) {
            if (type.getName().equals(name)) {
                return type.getMsgType();
            }
        }
        return -1;
    }

    public String getProperty() {
        return property;
    }

    public int getMsgType() {
        return msgType;
    }

    public static String getName(int msgType) {
        MsgType [] types = MsgType.values();
        for (MsgType type : types) {
            if (type.getMsgType() == msgType) {
                return type.getName();
            }
        }
        return "";
    }

    public static String getNameByIndex(int index) {
        MsgType [] types = MsgType.values();
        for (MsgType type : types) {
            if (type.getIndex() == index) {
                return type.getName();
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public static int getIndex(int msgType) {
        MsgType [] types = MsgType.values();
        for (MsgType type : types) {
            if (type.getMsgType() == msgType) {
                return type.getIndex();
            }
        }
        return -1;
    }

    public int getIndex() {
        return index;
    }
}
