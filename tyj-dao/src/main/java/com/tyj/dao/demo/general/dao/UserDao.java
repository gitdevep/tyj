/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.general.bo.User;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user`
 */
public interface UserDao extends SqlMapDao<User, Integer> {

    User findUserByMap(Map<String, Object> params);

    List<User> findPageUser(Map<String, Object> params);

    void updateStatus(Map<String, Object> params);

    List<DeviceInfo> findPageTeams(Map<String, Object> map);
}