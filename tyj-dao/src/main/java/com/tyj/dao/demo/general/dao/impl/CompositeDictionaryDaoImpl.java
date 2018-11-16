/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.CompositeDictionary;
import com.tyj.dao.demo.general.dao.CompositeDictionaryDao;
import com.tyj.dao.demo.general.dao.CompositeDictionaryMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class corresponds to the database table `td_composite_dictionary`
 */
@Repository("compositeDictionaryDao")
public class CompositeDictionaryDaoImpl extends ConfigurableBaseSqlMapDao<CompositeDictionary, Long> implements CompositeDictionaryDao {
    @Autowired
    private CompositeDictionaryMapper compositeDictionaryMapper;

    @Override
    public DaoMapper<CompositeDictionary, Long> getDaoMapper() {
        return compositeDictionaryMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}