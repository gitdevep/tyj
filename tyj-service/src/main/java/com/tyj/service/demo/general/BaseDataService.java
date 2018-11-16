/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.general.bo.BaseData;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_base_data`
 */
public interface BaseDataService extends GenericService<BaseData, Long> {

    List<BaseData> findPage(Map<String, Object> params);
}