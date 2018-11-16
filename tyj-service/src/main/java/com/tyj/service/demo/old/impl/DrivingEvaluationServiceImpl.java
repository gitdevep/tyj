/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.old.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.old.bo.DrivingEvaluation;
import com.tyj.dao.demo.old.dao.DrivingEvaluationDao;
import com.tyj.service.demo.old.DrivingEvaluationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `driving_evaluation`
 */
@Service("drivingEvaluationService")
public class DrivingEvaluationServiceImpl extends GenericSqlMapServiceImpl<DrivingEvaluation, Integer> implements DrivingEvaluationService {
    @Resource(name = "drivingEvaluationDao")
    private DrivingEvaluationDao drivingEvaluationDao;

    @Override
    public SqlMapDao<DrivingEvaluation, Integer> getDao() {
        return drivingEvaluationDao;
    }

    @Override
    public List<DrivingEvaluation> findParams(Map<String, Object> params) {
        return drivingEvaluationDao.findParams(params);
    }
}