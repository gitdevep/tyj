/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.old.bo.TimeSpanFatigue;
import com.tyj.dao.demo.old.dao.TimeSpanFatigueDao;
import com.tyj.dao.demo.old.dao.TimeSpanFatigueMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * This class corresponds to the database table `time_span_fatigue`
 */
@Repository("timeSpanFatigueDao")
public class TimeSpanFatigueDaoImpl extends ConfigurableBaseSqlMapDao<TimeSpanFatigue, Integer> implements TimeSpanFatigueDao {
    @Autowired
    private TimeSpanFatigueMapper timeSpanFatigueMapper;

    @Override
    public DaoMapper<TimeSpanFatigue, Integer> getDaoMapper() {
        return timeSpanFatigueMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}