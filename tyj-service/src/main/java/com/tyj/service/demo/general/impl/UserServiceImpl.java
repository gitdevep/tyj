/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.general.bo.User;
import com.tyj.dao.demo.general.dao.UserDao;
import com.tyj.service.demo.general.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user`
 */
@Service("userService")
public class UserServiceImpl extends GenericSqlMapServiceImpl<User, Integer> implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public SqlMapDao<User, Integer> getDao() {
        return userDao;
    }

    @Override
    public User findUserByMap(Map<String, Object> params) {
        return userDao.findUserByMap(params);
    }

    @Override
    public List<User> findPageUser(Map<String, Object> params) {
        return userDao.findPageUser(params);
    }

    @Override
    public void updateStatus(Map<String, Object> params) {
        userDao.updateStatus(params);
    }

    @Override
    public List<DeviceInfo> findPageTeams(Map<String, Object> map) {
        return userDao.findPageTeams(map);
    }
}