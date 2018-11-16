/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.deviceGpsInfos.bo.ConditionBaseScore;
import com.tyj.dao.demo.deviceGpsInfos.dao.ConditionBaseScoreDao;
import com.tyj.dao.demo.deviceGpsInfos.dao.ConditionBaseScoreMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class corresponds to the database table `tb_condition_base_score`
 */
@Repository("conditionBaseScoreDao")
public class ConditionBaseScoreDaoImpl extends ConfigurableBaseSqlMapDao<ConditionBaseScore, Integer> implements ConditionBaseScoreDao {
    @Autowired
    private ConditionBaseScoreMapper conditionBaseScoreMapper;

    @Override
    public DaoMapper<ConditionBaseScore, Integer> getDaoMapper() {
        return conditionBaseScoreMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}