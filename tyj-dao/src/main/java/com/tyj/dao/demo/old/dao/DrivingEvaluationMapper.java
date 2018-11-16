/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.old.bo.DrivingEvaluation;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `driving_evaluation`
 */
@SqlMapper
public interface DrivingEvaluationMapper extends DaoMapper<DrivingEvaluation, Integer> {

    List<DrivingEvaluation> findParams(Map<String, Object> params);
}