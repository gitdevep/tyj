/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.BaseData;
import com.tyj.dao.demo.general.bo.TeamDevice;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_base_data`
 */
@SqlMapper
public interface BaseDataMapper extends DaoMapper<BaseData, Long> {

    List<BaseData> findPage(Map<String, Object> params);

    /**
     * This class corresponds to the database table `tb_team_device`
     */
    interface TeamDeviceDao extends SqlMapDao<TeamDevice, Integer> {

        void delMember(Map<String, Object> params);
    }

    /**
     * This class corresponds to the database table `tb_team_device`
     */
    @SqlMapper
    interface TeamDeviceMapper extends DaoMapper<TeamDevice, Integer> {
        void delMember(Map<String, Object> params);
    }
}