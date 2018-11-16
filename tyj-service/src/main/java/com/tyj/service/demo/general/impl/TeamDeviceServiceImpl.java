/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.TeamDevice;
import com.tyj.dao.demo.general.dao.BaseDataMapper;
import com.tyj.service.demo.general.TeamDeviceService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * This class corresponds to the database table `tb_team_device`
 */
@Service("teamDeviceService")
public class TeamDeviceServiceImpl extends GenericSqlMapServiceImpl<TeamDevice, Integer> implements TeamDeviceService {
    @Resource(name = "teamDeviceDao")
    private BaseDataMapper.TeamDeviceDao teamDeviceDao;

    @Override
    public SqlMapDao<TeamDevice, Integer> getDao() {
        return teamDeviceDao;
    }

    @Override
    public void delMember(Map<String, Object> params) {
        teamDeviceDao.delMember(params);
    }
}