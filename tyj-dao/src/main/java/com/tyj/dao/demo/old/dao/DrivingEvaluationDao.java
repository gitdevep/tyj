/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.old.bo.DrivingEvaluation;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `driving_evaluation`
 */
public interface DrivingEvaluationDao extends SqlMapDao<DrivingEvaluation, Integer> {

    List<DrivingEvaluation> findParams(Map<String, Object> params);
}