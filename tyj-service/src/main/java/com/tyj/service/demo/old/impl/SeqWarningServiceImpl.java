/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.old.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.old.bo.SeqWarning;
import com.tyj.dao.demo.old.dao.SeqWarningDao;
import com.tyj.service.demo.old.SeqWarningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * This class corresponds to the database table `seq_warning`
 */
@Service("seqWarningService")
public class SeqWarningServiceImpl extends GenericSqlMapServiceImpl<SeqWarning, Integer> implements SeqWarningService {
    @Resource(name = "seqWarningDao")
    private SeqWarningDao seqWarningDao;

    @Override
    public SqlMapDao<SeqWarning, Integer> getDao() {
        return seqWarningDao;
    }
}