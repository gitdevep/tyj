/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.general.bo.Route;
import com.tyj.dao.demo.general.dao.RouteDao;
import com.tyj.service.demo.general.RouteService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_route`
 */
@Service("routeService")
public class RouteServiceImpl extends GenericSqlMapServiceImpl<Route, Integer> implements RouteService {
    @Resource(name = "routeDao")
    private RouteDao routeDao;

    @Override
    public SqlMapDao<Route, Integer> getDao() {
        return routeDao;
    }

    @Override
    public List<Route> findPageRoute(Map<String, Object> params) {
        return routeDao.findPageRoute(params);
    }
}