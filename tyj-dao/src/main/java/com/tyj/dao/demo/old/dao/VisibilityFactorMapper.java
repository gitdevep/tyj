/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.old.bo.VisibilityFactor;

import java.util.HashMap;

/**
 * This class corresponds to the database table `visibility_factor`
 */
@SqlMapper
public interface VisibilityFactorMapper extends DaoMapper<VisibilityFactor, HashMap> {
}