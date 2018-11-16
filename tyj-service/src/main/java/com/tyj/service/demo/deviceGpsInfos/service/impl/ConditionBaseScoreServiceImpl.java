/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.deviceGpsInfos.service.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.vo.Constant;
import com.tyj.dao.demo.deviceGpsInfos.bo.ConditionBaseScore;
import com.tyj.dao.demo.deviceGpsInfos.dao.ConditionBaseScoreDao;
import com.tyj.dao.demo.old.bo.FactorWarning;
import com.tyj.service.demo.deviceGpsInfos.service.ConditionBaseScoreService;
import javax.annotation.Resource;

import com.tyj.service.demo.old.FactorWarningService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_condition_base_score`
 */
@Service("conditionBaseScoreService")
public class ConditionBaseScoreServiceImpl extends GenericSqlMapServiceImpl<ConditionBaseScore, Integer> implements ConditionBaseScoreService, InitializingBean {
    @Resource(name = "conditionBaseScoreDao")
    private ConditionBaseScoreDao conditionBaseScoreDao;

    @Resource(name = "factorWarningService")
    private FactorWarningService factorWarningService;

    @Override
    public SqlMapDao<ConditionBaseScore, Integer> getDao() {
        return conditionBaseScoreDao;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        load();
    }

    public void load() {
        Constant.CONDITION_BASE_SCORE_MAP.clear();
        Constant.FACTOR_WARNING.clear();
        List<ConditionBaseScore> scores = conditionBaseScoreDao.findAll();
        for (ConditionBaseScore score : scores) {
            Constant.CONDITION_BASE_SCORE_MAP.put(score.getFlagType(), score);
        }

        Map<Integer, Map<Integer, FactorWarning>> maps = new HashMap<Integer, Map<Integer, FactorWarning>>();
        List<FactorWarning> factorWarnings = factorWarningService.findAll();
        for (FactorWarning factorWarning : factorWarnings) {
            if (maps.containsKey(factorWarning.getFlagType())) {
                Map<Integer, FactorWarning> tmp = maps.get(factorWarning.getFlagType());
                tmp.put(factorWarning.getId(), factorWarning);
            } else {
                Map<Integer, FactorWarning> tmp = new HashMap<Integer, FactorWarning>();
                tmp.put(factorWarning.getId(), factorWarning);
                maps.put(factorWarning.getFlagType(), tmp);
            }
        }
        Constant.FACTOR_WARNING.putAll(maps);
    }
}