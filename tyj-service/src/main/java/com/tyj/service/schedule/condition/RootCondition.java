/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import java.util.ArrayList;
import java.util.List;

/**
 * 根条件
 * Author: CK
 * Date: 2016/2/28
 */
public class RootCondition extends AbstractCondition {

    /**
     * 每条记录产生一个条件,所有条件集合
     */
    List<Condition> conditions = new ArrayList<Condition>();

    public RootCondition(Object obj) {
        super(obj, 0);
    }

    @Override
    public double calculateScore() {
        double sum = 0.0;
        for (Condition condition : conditions) {
            sum += condition.calculateScore();
        }
        return sum;
    }

    @Override
    public double calculateExtendScore() {
        return 1;
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }
}
