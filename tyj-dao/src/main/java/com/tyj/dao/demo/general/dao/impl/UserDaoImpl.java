/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.general.bo.User;
import com.tyj.dao.demo.general.dao.UserDao;
import com.tyj.dao.demo.general.dao.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user`
 */
@Repository("userDao")
public class UserDaoImpl extends ConfigurableBaseSqlMapDao<User, Integer> implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public DaoMapper<User, Integer> getDaoMapper() {
        return userMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public User findUserByMap(Map<String, Object> params) {
        return userMapper.findUserByMap(params);
    }

    @Override
    public List<User> findPageUser(Map<String, Object> params) {
        return userMapper.findPageUser(params);
    }

    @Override
    public void updateStatus(Map<String, Object> params) {
        userMapper.updateStatus(params);
    }

    @Override
    public List<DeviceInfo> findPageTeams(Map<String, Object> map) {
        return userMapper.findPageTeams(map);
    }
}