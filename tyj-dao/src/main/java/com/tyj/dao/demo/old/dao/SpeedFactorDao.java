/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.old.bo.SpeedFactor;

import java.util.HashMap;

/**
 * This class corresponds to the database table `speed_factor`
 */
public interface SpeedFactorDao extends SqlMapDao<SpeedFactor, HashMap> {
}