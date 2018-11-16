/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.general.bo.TeamRoute;
import com.tyj.dao.demo.general.dao.TeamRouteDao;
import com.tyj.service.demo.general.TeamRouteService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * This class corresponds to the database table `tb_team_route`
 */
@Service("teamRouteService")
public class TeamRouteServiceImpl extends GenericSqlMapServiceImpl<TeamRoute, Integer> implements TeamRouteService {
    @Resource(name = "teamRouteDao")
    private TeamRouteDao teamRouteDao;

    @Override
    public SqlMapDao<TeamRoute, Integer> getDao() {
        return teamRouteDao;
    }
}