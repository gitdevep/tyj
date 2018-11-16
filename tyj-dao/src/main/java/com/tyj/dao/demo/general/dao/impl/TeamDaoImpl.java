/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.general.bo.Team;
import com.tyj.dao.demo.general.dao.TeamDao;
import com.tyj.dao.demo.general.dao.TeamMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_team`
 */
@Repository("teamDao")
public class TeamDaoImpl extends ConfigurableBaseSqlMapDao<Team, Integer> implements TeamDao {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public DaoMapper<Team, Integer> getDaoMapper() {
        return teamMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public List<Team> findPageTeam(Map<String, Object> params) {
        return teamMapper.findPageTeam(params);
    }
}