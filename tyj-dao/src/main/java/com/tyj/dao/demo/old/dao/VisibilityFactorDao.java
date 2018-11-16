/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.old.bo.VisibilityFactor;

import java.util.HashMap;

/**
 * This class corresponds to the database table `visibility_factor`
 */
public interface VisibilityFactorDao extends SqlMapDao<VisibilityFactor, HashMap> {
}