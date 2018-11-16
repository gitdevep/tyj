/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.old.bo.VisibilityFactor;
import com.tyj.dao.demo.old.dao.VisibilityFactorDao;
import com.tyj.dao.demo.old.dao.VisibilityFactorMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * This class corresponds to the database table `visibility_factor`
 */
@Repository("visibilityFactorDao")
public class VisibilityFactorDaoImpl extends ConfigurableBaseSqlMapDao<VisibilityFactor, HashMap> implements VisibilityFactorDao {
    @Autowired
    private VisibilityFactorMapper visibilityFactorMapper;

    @Override
    public DaoMapper<VisibilityFactor, HashMap> getDaoMapper() {
        return visibilityFactorMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}