/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/17
 */
public enum FactorAdjustor {
    seq_warning_adjustor(1, "seq_warning_adjustor"),
    speed_adjustor(1, "speed_adjustor"),
    time_slot_fatigue_adjustor(2, "time_slot_fatigue_adjustor"),
    time_span_fatigure_adjustor(2, "time_span_fatigure_adjustor"),
    visibility_adjustor(2, "visibility_adjustor"),
    ;
    private String name;
    private int diff;
    FactorAdjustor(int diff, String name) {
        this.diff = diff;
        this.name = name;
    }

    public int getDiff() {
        return diff;
    }
}
