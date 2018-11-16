package com.tyj.dao.demo.vo;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/9
 */
public enum OverSpeedLimitValue {
    ZERO(0, 5, "5"),
    ONE(1, 10, "10"),
    TWO(2, 15, "15"),
    THREE(3, 20, "20"),
    FOUR(4, 30, "30"),
    FIVE(5, 5, "40"),
    SIX(6, 10, "50"),
    SEVEN(7, 15, "60"),
    EIGHT(8, 20, "70"),
    NINE(9, 30, "80"),
    TEN(10, 5, "90"),
    ELEVEN(11, 10, "100"),
    TWELVE(12, 15, "110"),
    THIRTEEN(13, 20, "120"),
    FOURTEEN(14, Integer.MAX_VALUE, "~"),
    ;
    private int index;
    private int time;
    private String desc;
    OverSpeedLimitValue(int index, int time, String desc) {
        this.index = index;
        this.time = time;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public int getTime() {
        return time;
    }

    public static int getIndex(int time) {
        OverSpeedTime [] overSpeedTimes = OverSpeedTime.values();
        for (OverSpeedTime overSpeedTime : overSpeedTimes) {
            if (time < overSpeedTime.getTime()) {
                return overSpeedTime.getIndex();
            }
        }
        return -1;
    }
}
