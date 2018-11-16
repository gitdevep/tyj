/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.CompositeDictionary;
import com.tyj.dao.demo.general.dao.CompositeDictionaryDao;
import com.tyj.service.demo.general.CompositeDictionaryService;
import org.springframework.stereotype.Service;

/**
 * This class corresponds to the database table `td_composite_dictionary`
 */
@Service("compositeDictionaryService")
public class CompositeDictionaryServiceImpl extends GenericSqlMapServiceImpl<CompositeDictionary, Long> implements CompositeDictionaryService {
    @Resource(name = "compositeDictionaryDao")
    private CompositeDictionaryDao compositeDictionaryDao;

    @Override
    public SqlMapDao<CompositeDictionary, Long> getDao() {
        return compositeDictionaryDao;
    }
}