/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.general.bo.Team;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_team`
 */
public interface TeamService extends GenericService<Team, Integer> {

    List<Team> findPageTeam(Map<String, Object> params);
}