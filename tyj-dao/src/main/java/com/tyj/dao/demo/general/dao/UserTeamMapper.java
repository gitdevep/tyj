/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.UserTeam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_team`
 */
@SqlMapper
public interface UserTeamMapper extends DaoMapper<UserTeam, Integer> {
    void delMember(Map<String, Object> params);

    List<Integer> findTeamIdsByUserId(@Param("userId") Integer userId);
}