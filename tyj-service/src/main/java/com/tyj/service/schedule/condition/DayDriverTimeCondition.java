/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import cn.vansky.framework.common.util.DateUtil;
import com.tyj.dao.demo.old.bo.FactorWarning;

import java.util.Date;

/**
 * 每天驾驶时长
 * Author: CK
 * Date: 2016/2/28
 */
public class DayDriverTimeCondition extends AbstractCondition {
    /**
     * 开始驾车时间
     */
    private Date startDate;

    public DayDriverTimeCondition(Object obj) {
        super(obj, FactorWarning.DAY_DRIVER_TIME);
    }

    @Override
    public double calculateExtendScore() {
        FactorWarning timeSpan = get((int) DateUtil.getBetweenDiff(eventTime, startDate, DateUtil.HOUR_TIME));
        if (timeSpan == null) {
            timeSpan = get(1);
        }
        return getValue(timeSpan);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
