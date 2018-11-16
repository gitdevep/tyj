/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.Route;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_route`
 */
@SqlMapper
public interface RouteMapper extends DaoMapper<Route, Integer> {

    List<Route> findPageRoute(Map<String, Object> params);
}