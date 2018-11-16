package com.tyj.dao.demo.vo;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/9
 */
public enum OverSpeedTime {
    ZERO(0, 10, "超速时长在0—10秒次数"),
    ONE(1, 20, "超速时长在10—20秒次数"),
    TWO(2, 30, "超速时长在20—30秒次数"),
    THREE(3, 60, "超速时长在30—60秒次数"),
    FOUR(4, 300, "超速时长在1—5分钟次数"),
    FIVE(5, Integer.MAX_VALUE, "超速时长在5分钟以上次数"),
    ;
    private int index;
    private int time;
    private String desc;
    OverSpeedTime(int index, int time, String desc) {
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
