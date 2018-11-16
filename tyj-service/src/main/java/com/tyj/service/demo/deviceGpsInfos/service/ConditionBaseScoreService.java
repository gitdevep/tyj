/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.deviceGpsInfos.service;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.deviceGpsInfos.bo.ConditionBaseScore;

/**
 * This class corresponds to the database table `tb_condition_base_score`
 */
public interface ConditionBaseScoreService extends GenericService<ConditionBaseScore, Integer> {
    /**
     * 加载基础类型分数到本地缓存
     */
    void load();
}