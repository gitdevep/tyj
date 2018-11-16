/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/5/14
 */
public enum PersonCollideSpeedMaxValue {
    ZERO(0, 20, "速度在<0,20>以内"),
    ONE(1, 40, "速度在<20,40>以内"),
    TWO(2, 60, "速度在<40,60>以内"),
    THREE(3, 80, "速度在<60,80>以内"),
    FOUR(4, 120, "速度在<80,120>以内"),
    FIVE(5, Integer.MAX_VALUE, "速度在<120,*>以内"),
            ;
    private int index;
    private int speed;
    private String desc;
    PersonCollideSpeedMaxValue(int index, int time, String desc) {
        this.index = index;
        this.speed = time;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public int getSpeed() {
        return speed;
    }

    public static int getIndex(int speed) {
        PersonCollideSpeedMaxValue [] values = PersonCollideSpeedMaxValue.values();
        for (PersonCollideSpeedMaxValue value : values) {
            if (speed < value.getSpeed()) {
                return value.getIndex();
            }
        }
        return -1;
    }
}
