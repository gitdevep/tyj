/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.BaseData;
import com.tyj.dao.demo.general.dao.BaseDataDao;
import com.tyj.dao.demo.general.dao.BaseDataMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_base_data`
 */
@Repository("baseDataDao")
public class BaseDataDaoImpl extends ConfigurableBaseSqlMapDao<BaseData, Long> implements BaseDataDao {
    @Autowired
    private BaseDataMapper baseDataMapper;

    @Override
    public DaoMapper<BaseData, Long> getDaoMapper() {
        return baseDataMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public List<BaseData> findPage(Map<String, Object> params) {
        return baseDataMapper.findPage(params);
    }
}