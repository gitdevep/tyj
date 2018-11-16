/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.old.bo.TimeSlotFatigue;

import java.util.HashMap;

/**
 * This class corresponds to the database table `time_slot_fatigue`
 */
@SqlMapper
public interface TimeSlotFatigueMapper extends DaoMapper<TimeSlotFatigue, HashMap> {
}