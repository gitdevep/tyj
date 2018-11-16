/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.UserTeam;
import com.tyj.dao.demo.general.dao.UserTeamDao;
import com.tyj.dao.demo.general.dao.UserTeamMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_team`
 */
@Repository("userTeamDao")
public class UserTeamDaoImpl extends ConfigurableBaseSqlMapDao<UserTeam, Integer> implements UserTeamDao {
    @Autowired
    private UserTeamMapper userTeamMapper;

    public DaoMapper<UserTeam, Integer> getDaoMapper() {
        return userTeamMapper;
    }

    @Resource(name = "sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public void delMember(Map<String, Object> params) {
        userTeamMapper.delMember(params);
    }

    @Override
    public List<Integer> findTeamIdsByUserId(Integer userId) {
        return userTeamMapper.findTeamIdsByUserId(userId);
    }
}