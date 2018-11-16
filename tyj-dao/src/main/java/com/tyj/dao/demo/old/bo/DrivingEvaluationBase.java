/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

import java.util.Date;

/**
 * This class corresponds to the database table `driving_evaluation`
 */
public abstract class DrivingEvaluationBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `driving_evaluation`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `driving_evaluation`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `driving_evaluation`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `driving_evaluation`.device_id
     */
    private static final String PROPERTY_DEVICEID = "deviceId";

    /**
     * This field corresponds to the database column `driving_evaluation`.device_id
     */
    private static final String PROPERTY_REMARK_DEVICEID = "设备号";

    /**
     * This field corresponds to the database column `driving_evaluation`.device_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICEID)
    private Integer deviceId;

    /**
     * This field corresponds to the database column `driving_evaluation`.evaluate_time
     */
    private static final String PROPERTY_EVALUATETIME = "evaluateTime";

    /**
     * This field corresponds to the database column `driving_evaluation`.evaluate_time
     */
    private static final String PROPERTY_REMARK_EVALUATETIME = "计算时间";

    /**
     * This field corresponds to the database column `driving_evaluation`.evaluate_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_EVALUATETIME)
    private Date evaluateTime;

    /**
     * This field corresponds to the database column `driving_evaluation`.scores
     */
    private static final String PROPERTY_SCORES = "scores";

    /**
     * This field corresponds to the database column `driving_evaluation`.scores
     */
    private static final String PROPERTY_REMARK_SCORES = "分数";

    /**
     * This field corresponds to the database column `driving_evaluation`.scores
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SCORES)
    private Double scores;

    /**
     * This field corresponds to the database column `driving_evaluation`.driving_time
     */
    private static final String PROPERTY_DRIVINGTIME = "drivingTime";

    /**
     * This field corresponds to the database column `driving_evaluation`.driving_time
     */
    private static final String PROPERTY_REMARK_DRIVINGTIME = "驾驶时间";

    /**
     * This field corresponds to the database column `driving_evaluation`.driving_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DRIVINGTIME)
    private Integer drivingTime;

    /**
     * This field corresponds to the database column `driving_evaluation`.sum
     */
    private static final String PROPERTY_SUM = "sum";

    /**
     * This field corresponds to the database column `driving_evaluation`.sum
     */
    private static final String PROPERTY_REMARK_SUM = "总数";

    /**
     * This field corresponds to the database column `driving_evaluation`.sum
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SUM)
    private Integer sum;

    /**
     * This method returns the value of the database column `driving_evaluation`.id
     *
     * @return the value of `driving_evaluation`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `driving_evaluation`.id
     *
     * @param id the value for `driving_evaluation`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `driving_evaluation`.device_id
     *
     * @return the value of `driving_evaluation`.device_id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * This method sets the value of the database column `driving_evaluation`.device_id
     *
     * @param deviceId the value for `driving_evaluation`.device_id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * This method returns the value of the database column `driving_evaluation`.evaluate_time
     *
     * @return the value of `driving_evaluation`.evaluate_time
     */
    public Date getEvaluateTime() {
        return evaluateTime;
    }

    /**
     * This method sets the value of the database column `driving_evaluation`.evaluate_time
     *
     * @param evaluateTime the value for `driving_evaluation`.evaluate_time
     */
    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    /**
     * This method returns the value of the database column `driving_evaluation`.scores
     *
     * @return the value of `driving_evaluation`.scores
     */
    public Double getScores() {
        return scores;
    }

    /**
     * This method sets the value of the database column `driving_evaluation`.scores
     *
     * @param scores the value for `driving_evaluation`.scores
     */
    public void setScores(Double scores) {
        this.scores = scores;
    }

    /**
     * This method returns the value of the database column `driving_evaluation`.driving_time
     *
     * @return the value of `driving_evaluation`.driving_time
     */
    public Integer getDrivingTime() {
        return drivingTime;
    }

    /**
     * This method sets the value of the database column `driving_evaluation`.driving_time
     *
     * @param drivingTime the value for `driving_evaluation`.driving_time
     */
    public void setDrivingTime(Integer drivingTime) {
        this.drivingTime = drivingTime;
    }

    /**
     * This method returns the value of the database column `driving_evaluation`.sum
     *
     * @return the value of `driving_evaluation`.sum
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * This method sets the value of the database column `driving_evaluation`.sum
     *
     * @param sum the value for `driving_evaluation`.sum
     */
    public void setSum(Integer sum) {
        this.sum = sum;
    }
}