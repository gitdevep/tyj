/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.old;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.old.bo.DrivingEvaluation;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `driving_evaluation`
 */
public interface DrivingEvaluationService extends GenericService<DrivingEvaluation, Integer> {

    List<DrivingEvaluation> findParams(Map<String, Object> params);
}