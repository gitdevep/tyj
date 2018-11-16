/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.UserDevice;
import com.tyj.dao.demo.general.dao.UserDeviceDao;
import com.tyj.dao.demo.general.dao.UserDeviceMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_device`
 */
@Repository("userDeviceDao")
public class UserDeviceDaoImpl extends ConfigurableBaseSqlMapDao<UserDevice, Integer> implements UserDeviceDao {
    @Autowired
    private UserDeviceMapper userDeviceMapper;

    public DaoMapper<UserDevice, Integer> getDaoMapper() {
        return userDeviceMapper;
    }

    @Resource(name = "sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public void delMember(Map<String, Object> params) {
        userDeviceMapper.delMember(params);
    }

    @Override
    public List<Integer> findDeviceIdsByUserId(Integer userId) {
        return userDeviceMapper.findDeviceIdsByUserId(userId);
    }
}