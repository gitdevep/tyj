/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.Team;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_team`
 */
@SqlMapper
public interface TeamMapper extends DaoMapper<Team, Integer> {

    List<Team> findPageTeam(Map<String, Object> params);
}