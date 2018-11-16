/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.general.bo.BaseData;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_base_data`
 */
public interface BaseDataDao extends SqlMapDao<BaseData, Long> {

    List<BaseData> findPage(Map<String, Object> params);
}