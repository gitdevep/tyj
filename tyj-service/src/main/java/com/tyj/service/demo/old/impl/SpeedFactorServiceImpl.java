/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.old.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.old.bo.SpeedFactor;
import com.tyj.dao.demo.old.dao.SpeedFactorDao;
import com.tyj.service.demo.old.SpeedFactorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * This class corresponds to the database table `speed_factor`
 */
@Service("speedFactorService")
public class SpeedFactorServiceImpl extends GenericSqlMapServiceImpl<SpeedFactor, HashMap> implements SpeedFactorService {
    @Resource(name = "speedFactorDao")
    private SpeedFactorDao speedFactorDao;

    @Override
    public SqlMapDao<SpeedFactor, HashMap> getDao() {
        return speedFactorDao;
    }
}