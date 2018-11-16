/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.general.bo.Route;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_route`
 */
public interface RouteDao extends SqlMapDao<Route, Integer> {
    List<Route> findPageRoute(Map<String, Object> params);
}