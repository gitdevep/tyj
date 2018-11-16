/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.old.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.old.bo.TimeSpanFatigue;
import com.tyj.dao.demo.old.dao.TimeSpanFatigueDao;
import com.tyj.service.demo.old.TimeSpanFatigueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * This class corresponds to the database table `time_span_fatigue`
 */
@Service("timeSpanFatigueService")
public class TimeSpanFatigueServiceImpl extends GenericSqlMapServiceImpl<TimeSpanFatigue, Integer> implements TimeSpanFatigueService {
    @Resource(name = "timeSpanFatigueDao")
    private TimeSpanFatigueDao timeSpanFatigueDao;

    @Override
    public SqlMapDao<TimeSpanFatigue, Integer> getDao() {
        return timeSpanFatigueDao;
    }
}