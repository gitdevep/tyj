/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.general.bo.UserTeam;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_team`
 */
public interface UserTeamService extends GenericService<UserTeam, Integer> {
    void delMember(Map<String, Object> params);

    List<Integer> findTeamIdsByUserId(Integer userId);
}