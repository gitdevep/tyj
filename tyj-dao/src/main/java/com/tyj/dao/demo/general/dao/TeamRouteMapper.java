/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.TeamRoute;

/**
 * This class corresponds to the database table `tb_team_route`
 */
@SqlMapper
public interface TeamRouteMapper extends DaoMapper<TeamRoute, Integer> {
}