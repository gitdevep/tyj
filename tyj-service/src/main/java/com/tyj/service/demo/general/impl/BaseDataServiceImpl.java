/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.BaseData;
import com.tyj.dao.demo.general.dao.BaseDataDao;
import com.tyj.service.demo.general.BaseDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_base_data`
 */
@Service("baseDataService")
public class BaseDataServiceImpl extends GenericSqlMapServiceImpl<BaseData, Long> implements BaseDataService {
    @Resource(name = "baseDataDao")
    private BaseDataDao baseDataDao;

    @Override
    public SqlMapDao<BaseData, Long> getDao() {
        return baseDataDao;
    }

    @Override
    public List<BaseData> findPage(Map<String, Object> params) {
        return baseDataDao.findPage(params);
    }
}