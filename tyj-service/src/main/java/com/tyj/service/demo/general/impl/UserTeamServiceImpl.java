/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.UserTeam;
import com.tyj.dao.demo.general.dao.UserTeamDao;
import com.tyj.service.demo.general.UserTeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_team`
 */
@Service("userTeamService")
public class UserTeamServiceImpl extends GenericSqlMapServiceImpl<UserTeam, Integer> implements UserTeamService {
    @Resource(name = "userTeamDao")
    private UserTeamDao userTeamDao;

    public SqlMapDao<UserTeam, Integer> getDao() {
        return userTeamDao;
    }

    @Override
    public void delMember(Map<String, Object> params) {
        userTeamDao.delMember(params);
    }

    @Override
    public List<Integer> findTeamIdsByUserId(Integer userId) {
        return userTeamDao.findTeamIdsByUserId(userId);
    }
}