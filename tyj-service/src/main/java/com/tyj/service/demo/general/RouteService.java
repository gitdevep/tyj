/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.general.bo.Route;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_route`
 */
public interface RouteService extends GenericService<Route, Integer> {

    List<Route> findPageRoute(Map<String, Object> params);
}