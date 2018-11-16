/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.general.bo.Team;
import com.tyj.dao.demo.general.dao.TeamDao;
import com.tyj.service.demo.general.TeamService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_team`
 */
@Service("teamService")
public class TeamServiceImpl extends GenericSqlMapServiceImpl<Team, Integer> implements TeamService {
    @Resource(name = "teamDao")
    private TeamDao teamDao;

    @Override
    public SqlMapDao<Team, Integer> getDao() {
        return teamDao;
    }

    @Override
    public List<Team> findPageTeam(Map<String, Object> params) {
        return teamDao.findPageTeam(params);
    }
}