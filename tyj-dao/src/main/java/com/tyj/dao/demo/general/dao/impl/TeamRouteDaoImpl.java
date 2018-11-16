/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.general.bo.TeamRoute;
import com.tyj.dao.demo.general.dao.TeamRouteDao;
import com.tyj.dao.demo.general.dao.TeamRouteMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class corresponds to the database table `tb_team_route`
 */
@Repository("teamRouteDao")
public class TeamRouteDaoImpl extends ConfigurableBaseSqlMapDao<TeamRoute, Integer> implements TeamRouteDao {
    @Autowired
    private TeamRouteMapper teamRouteMapper;

    @Override
    public DaoMapper<TeamRoute, Integer> getDaoMapper() {
        return teamRouteMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}