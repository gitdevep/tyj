/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.deviceGpsInfos.bo.ConditionBaseScore;

/**
 * This class corresponds to the database table `tb_condition_base_score`
 */
@SqlMapper
public interface ConditionBaseScoreMapper extends DaoMapper<ConditionBaseScore, Integer> {
}