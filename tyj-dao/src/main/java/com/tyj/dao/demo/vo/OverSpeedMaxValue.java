package com.tyj.dao.demo.vo;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/9
 */
public enum OverSpeedMaxValue {
    ZERO(0, 10, "最大超速值在限速值+10以内次数"),
    ONE(1, 20, "最大超速值在限速值+10以上+20以下次数"),
    TWO(2, 30, "最大超速值在限速值+20以上+30以下次数"),
    THREE(3, 40, "最大超速值在限速值+30以上+40以下次数"),
    FOUR(4, Integer.MAX_VALUE, "最大超速值在限速值+40以上次数"),
    ;
    private int index;
    private int time;
    private String desc;
    OverSpeedMaxValue(int index, int time, String desc) {
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
