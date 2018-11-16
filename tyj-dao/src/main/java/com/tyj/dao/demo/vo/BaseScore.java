/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/17
 */
public enum BaseScore {
    headwayMonitoringWarning(3, "车距监测", 30),
    urbanForwardCollisionWarning(5, "城市前碰撞", 20),
    forwardCollisionWarning(6, "车辆前部碰撞", 80),
    overSpeedWarning(4, "限速警示", 40),
    leftLaneDepartureWarning(1, "左车道偏离", 40),
    rightLaneDepartureWarning(2, "右车道偏离", 40),
    ;
    private String name;
    private int type;
    private int score;
    BaseScore(int type, String name, int score) {
        this.type = type;
        this.name = name;
        this.score = score;
    }

    public static int getScore(int type) {
        BaseScore [] baseScores = BaseScore.values();
        for (BaseScore score : baseScores) {
            if (score.getType() == type) {
                return score.getScore();
            }
        }
        return 0;
    }

    public int getType() {
        return type;
    }

    public int getScore() {
        return score;
    }
}
