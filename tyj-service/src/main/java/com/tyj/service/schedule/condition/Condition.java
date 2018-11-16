/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

/**
 * 条件接口
 * Author: CK
 * Date: 2016/2/28
 */
public interface Condition {
    /**
     * 计算分数接口
     * @return 分数
     */
    double calculateScore();

    /**
     * 根据条件类型查询基础分数
     * @param type 条件类型
     */
    void getTypeScoreBaseByCondition(Integer type);
}
