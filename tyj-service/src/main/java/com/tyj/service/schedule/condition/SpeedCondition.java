/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import com.tyj.dao.demo.old.bo.FactorWarning;

/**
 * 速度来计算分数
 * 先计算基础分数，当某速度下的分数小于基础分时，不做处理
 * 当某速度下的分数大于基础分时，再计算一下速度下的分数，最后基础分与速度下的分数相加
 * Author: CK
 * Date: 2016/2/28
 */
public class SpeedCondition extends AbstractCondition {

    /**
     * 当前速度
     */
    private Integer speed;

    public SpeedCondition(Object obj) {
        super(obj, FactorWarning.SPEED_FACTOR);
    }

    @Override
    public double calculateExtendScore() {
        int tmp = speed / 10 * 10;
        FactorWarning speed = get(tmp);
        double extendScore = getValue(speed);
        // 当前速度下的分数大于基础分，计算一下扩展分数
        if (extendScore > baseScore) {
            return extendScore;
        }
        return 0;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
