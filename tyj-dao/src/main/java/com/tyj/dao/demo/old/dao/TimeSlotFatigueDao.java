/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.old.bo.TimeSlotFatigue;

import java.util.HashMap;

/**
 * This class corresponds to the database table `time_slot_fatigue`
 */
public interface TimeSlotFatigueDao extends SqlMapDao<TimeSlotFatigue, HashMap> {
}