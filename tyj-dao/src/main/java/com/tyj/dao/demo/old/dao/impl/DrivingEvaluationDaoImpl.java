/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.old.bo.DrivingEvaluation;
import com.tyj.dao.demo.old.dao.DrivingEvaluationDao;
import com.tyj.dao.demo.old.dao.DrivingEvaluationMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `driving_evaluation`
 */
@Repository("drivingEvaluationDao")
public class DrivingEvaluationDaoImpl extends ConfigurableBaseSqlMapDao<DrivingEvaluation, Integer> implements DrivingEvaluationDao {
    @Autowired
    private DrivingEvaluationMapper drivingEvaluationMapper;

    @Override
    public DaoMapper<DrivingEvaluation, Integer> getDaoMapper() {
        return drivingEvaluationMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public List<DrivingEvaluation> findParams(Map<String, Object> params) {
        return drivingEvaluationMapper.findParams(params);
    }
}