/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.old.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.old.bo.VisibilityFactor;
import com.tyj.dao.demo.old.dao.VisibilityFactorDao;
import com.tyj.service.demo.old.VisibilityFactorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * This class corresponds to the database table `visibility_factor`
 */
@Service("visibilityFactorService")
public class VisibilityFactorServiceImpl extends GenericSqlMapServiceImpl<VisibilityFactor, HashMap> implements VisibilityFactorService {
    @Resource(name = "visibilityFactorDao")
    private VisibilityFactorDao visibilityFactorDao;

    @Override
    public SqlMapDao<VisibilityFactor, HashMap> getDao() {
        return visibilityFactorDao;
    }
}