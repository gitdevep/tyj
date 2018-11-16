/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.bo;

import cn.vansky.framework.common.util.DateUtil;

/**
 * This class corresponds to the database table `time_slot_fatigue`
 */
public class TimeSlotFatigue extends TimeSlotFatigueBase {
    private String rangeStartStr;
    private String rangeEndStr;

    public String getRangeStartStr() {
        return rangeStartStr;
    }

    public void setRangeStartStr() {
        this.rangeStartStr = DateUtil.format(DateUtil.HH_mm_ss, getRangeStart());
    }

    public String getRangeEndStr() {
        return rangeEndStr;
    }

    public void setRangeEndStr() {
        this.rangeEndStr = DateUtil.format(DateUtil.HH_mm_ss, getRangeEnd());
    }
}