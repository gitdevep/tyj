/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosActive;
import com.tyj.dao.demo.deviceGpsInfos.dao.DeviceGpsInfosActiveDao;
import com.tyj.dao.demo.deviceGpsInfos.dao.DeviceGpsInfosActiveMapper;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class corresponds to the database table `device_gps_infos_active`
 */
@Repository("deviceGpsInfosActiveDao")
public class DeviceGpsInfosActiveDaoImpl extends ConfigurableBaseSqlMapDao<DeviceGpsInfosActive, HashMap> implements DeviceGpsInfosActiveDao {
    @Autowired
    private DeviceGpsInfosActiveMapper deviceGpsInfosActiveMapper;

    @Override
    public DaoMapper<DeviceGpsInfosActive, HashMap> getDaoMapper() {
        return deviceGpsInfosActiveMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}