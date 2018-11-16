/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.old.bo.TimeSpanFatigue;

/**
 * This class corresponds to the database table `time_span_fatigue`
 */
@SqlMapper
public interface TimeSpanFatigueMapper extends DaoMapper<TimeSpanFatigue, Integer> {
}