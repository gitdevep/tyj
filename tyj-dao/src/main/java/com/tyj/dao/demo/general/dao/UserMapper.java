/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.general.bo.User;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user`
 */
@SqlMapper
public interface UserMapper extends DaoMapper<User, Integer> {

    User findUserByMap(Map<String, Object> params);

    List<User> findPageUser(Map<String, Object> params);

    void updateStatus(Map<String, Object> params);

    List<DeviceInfo> findPageTeams(Map<String, Object> map);
}