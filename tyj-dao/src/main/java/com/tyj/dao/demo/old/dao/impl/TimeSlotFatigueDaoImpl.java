/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.old.bo.TimeSlotFatigue;
import com.tyj.dao.demo.old.dao.TimeSlotFatigueDao;
import com.tyj.dao.demo.old.dao.TimeSlotFatigueMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * This class corresponds to the database table `time_slot_fatigue`
 */
@Repository("timeSlotFatigueDao")
public class TimeSlotFatigueDaoImpl extends ConfigurableBaseSqlMapDao<TimeSlotFatigue, HashMap> implements TimeSlotFatigueDao {
    @Autowired
    private TimeSlotFatigueMapper timeSlotFatigueMapper;

    @Override
    public DaoMapper<TimeSlotFatigue, HashMap> getDaoMapper() {
        return timeSlotFatigueMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}