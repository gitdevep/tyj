/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import cn.vansky.framework.common.util.DateUtil;
import com.tyj.dao.demo.old.bo.FactorWarning;

import java.util.Calendar;
import java.util.Date;

/**
 * 疲劳度
 * Author: CK
 * Date: 2016/2/28
 */
public class TimeFatigueCondition extends AbstractCondition {

    public TimeFatigueCondition(Object obj) {
        super(obj, FactorWarning.FATIGUE);
    }

    @Override
    public double calculateExtendScore() {
        int time = getTimeSlotFatigue(eventTime);
        FactorWarning timeSlot = get(time);
        double currentResult = getValue(timeSlot);
        return currentResult;
    }

    private int getTimeSlotFatigue(Date date) {
        int hour = DateUtil.getTimeNumber(date, Calendar.HOUR_OF_DAY) * 60;
        int minute = DateUtil.getTimeNumber(date, Calendar.MINUTE);
        int tmp = hour + minute;
        if (30 - tmp > 0) {
            return 30;
        } else if (150 - tmp > 0) {
            return 150;
        } else if (360 - tmp > 0) {
            return 360;
        } else if (600 - tmp > 0) {
            return 600;
        } else {
            return 1440;
        }
    }
}
