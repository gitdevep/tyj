/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.old.bo.SpeedFactor;
import com.tyj.dao.demo.old.dao.SpeedFactorDao;
import com.tyj.dao.demo.old.dao.SpeedFactorMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * This class corresponds to the database table `speed_factor`
 */
@Repository("speedFactorDao")
public class SpeedFactorDaoImpl extends ConfigurableBaseSqlMapDao<SpeedFactor, HashMap> implements SpeedFactorDao {
    @Autowired
    private SpeedFactorMapper speedFactorMapper;

    @Override
    public DaoMapper<SpeedFactor, HashMap> getDaoMapper() {
        return speedFactorMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}