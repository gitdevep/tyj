/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.general.bo.Route;
import com.tyj.dao.demo.general.dao.RouteDao;
import com.tyj.dao.demo.general.dao.RouteMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_route`
 */
@Repository("routeDao")
public class RouteDaoImpl extends ConfigurableBaseSqlMapDao<Route, Integer> implements RouteDao {
    @Autowired
    private RouteMapper routeMapper;

    @Override
    public DaoMapper<Route, Integer> getDaoMapper() {
        return routeMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public List<Route> findPageRoute(Map<String, Object> params) {
        return routeMapper.findPageRoute(params);
    }
}