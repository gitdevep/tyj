/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import cn.vansky.framework.common.util.DateUtil;
import com.tyj.dao.demo.old.bo.FactorWarning;

import java.util.Calendar;
import java.util.Date;

/**
 * 能见度
 * Author: CK
 * Date: 2016/2/28
 */
public class TimeVisibilityCondition extends AbstractCondition {

    public TimeVisibilityCondition(Object obj) {
        super(obj, FactorWarning.VISIBILITY);
    }

    @Override
    public double calculateExtendScore() {
        int time = getVisibility(eventTime);
        FactorWarning visibility = get(time);
        double currentResult = getValue(visibility);
        return currentResult;
    }

    private int getVisibility(Date date) {
        int hour = DateUtil.getTimeNumber(date, Calendar.HOUR_OF_DAY) * 60;
        int minute = DateUtil.getTimeNumber(date, Calendar.MINUTE);
        int tmp = hour + minute;
        if (300 - tmp > 0) {
            return 300;
        } else if (480 - tmp > 0) {
            return 480;
        } else if (1020 - tmp > 0) {
            return 1020;
        } else if (1260 - tmp > 0) {
            return 1260;
        } else {
            return 1440;
        }
    }
}
