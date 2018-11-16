/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.old.bo.SeqWarning;
import com.tyj.dao.demo.old.dao.SeqWarningDao;
import com.tyj.dao.demo.old.dao.SeqWarningMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * This class corresponds to the database table `seq_warning`
 */
@Repository("seqWarningDao")
public class SeqWarningDaoImpl extends ConfigurableBaseSqlMapDao<SeqWarning, Integer> implements SeqWarningDao {
    @Autowired
    private SeqWarningMapper seqWarningMapper;

    @Override
    public DaoMapper<SeqWarning, Integer> getDaoMapper() {
        return seqWarningMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}