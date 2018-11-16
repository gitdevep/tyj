/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.general.bo.Team;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_team`
 */
public interface TeamDao extends SqlMapDao<Team, Integer> {

    List<Team> findPageTeam(Map<String, Object> params);
}