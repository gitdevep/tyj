/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.old.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.old.bo.TimeSlotFatigue;
import com.tyj.dao.demo.old.dao.TimeSlotFatigueDao;
import com.tyj.service.demo.old.TimeSlotFatigueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * This class corresponds to the database table `time_slot_fatigue`
 */
@Service("timeSlotFatigueService")
public class TimeSlotFatigueServiceImpl extends GenericSqlMapServiceImpl<TimeSlotFatigue, HashMap> implements TimeSlotFatigueService {
    @Resource(name = "timeSlotFatigueDao")
    private TimeSlotFatigueDao timeSlotFatigueDao;

    @Override
    public SqlMapDao<TimeSlotFatigue, HashMap> getDao() {
        return timeSlotFatigueDao;
    }
}