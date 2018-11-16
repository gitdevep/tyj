/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;

import com.tyj.dao.demo.general.bo.TeamDevice;
import com.tyj.dao.demo.general.dao.BaseDataMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * This class corresponds to the database table `tb_team_device`
 */
@Repository("teamDeviceDao")
public class TeamDeviceDaoImpl extends ConfigurableBaseSqlMapDao<TeamDevice, Integer> implements BaseDataMapper.TeamDeviceDao {
    @Autowired
    private BaseDataMapper.TeamDeviceMapper teamDeviceMapper;

    @Override
    public DaoMapper<TeamDevice, Integer> getDaoMapper() {
        return teamDeviceMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public void delMember(Map<String, Object> params) {
        teamDeviceMapper.delMember(params);
    }
}