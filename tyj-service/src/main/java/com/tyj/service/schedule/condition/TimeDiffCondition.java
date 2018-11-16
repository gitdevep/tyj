/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import cn.vansky.framework.common.util.DateUtil;
import com.tyj.dao.demo.old.bo.FactorWarning;

import java.util.Date;

/**
 * 前后时间间隔1秒
 * Author: CK
 * Date: 2016/2/28
 */
public class TimeDiffCondition extends AbstractCondition {
    /**
     * 时间间隔阀值
     */
    public static final long DIFF = 1;
    /**
     * 前个时间
     */
    private Date frontDate;
    /**
     * 前个类型
     */
    private Byte frontType;

    public TimeDiffCondition(Object obj) {
        super(obj, FactorWarning.TIME_DIFF);
    }

    @Override
    public double calculateExtendScore() {
        FactorWarning factorWarning = get(1);
        if (null != eventTime && null != frontDate) {
            long diff = DateUtil.getBetweenDiff(eventTime, frontDate, DateUtil.SECOND_TIME);
            // 间隔时间小于阀值，计算扩展分数
            if (DIFF > diff) {
                double extendScore = getValue(factorWarning);
                return extendScore;
            }
        }
        return 0;
    }

    public void setFrontDate(Date frontDate) {
        this.frontDate = frontDate;
    }

    public void setFrontType(Byte frontType) {
        this.frontType = frontType;
    }
}
