/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.CompositeDictionary;

/**
 * This class corresponds to the database table `td_composite_dictionary`
 */
@SqlMapper
public interface CompositeDictionaryMapper extends DaoMapper<CompositeDictionary, Long> {
}