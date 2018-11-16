/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.general.bo.UserTeam;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_team`
 */
public interface UserTeamDao extends SqlMapDao<UserTeam, Integer> {
    void delMember(Map<String, Object> params);

    List<Integer> findTeamIdsByUserId(Integer userId);
}