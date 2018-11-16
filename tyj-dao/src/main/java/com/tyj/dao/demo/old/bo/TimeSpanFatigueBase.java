/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `time_span_fatigue`
 */
public abstract class TimeSpanFatigueBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `time_span_fatigue`.driving_span
     */
    private static final String PROPERTY_DRIVINGSPAN = "drivingSpan";

    /**
     * This field corresponds to the database column `time_span_fatigue`.driving_span
     */
    private static final String PROPERTY_REMARK_DRIVINGSPAN = "驾驶时间";

    /**
     * This field corresponds to the database column `time_span_fatigue`.driving_span
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DRIVINGSPAN)
    @Id
    private Integer drivingSpan;

    /**
     * This field corresponds to the database column `time_span_fatigue`.headwayMonitoringWarning
     */
    private static final String PROPERTY_HEADWAYMONITORINGWARNING = "headwayMonitoringWarning";

    /**
     * This field corresponds to the database column `time_span_fatigue`.headwayMonitoringWarning
     */
    private static final String PROPERTY_REMARK_HEADWAYMONITORINGWARNING = "车距监测";

    /**
     * This field corresponds to the database column `time_span_fatigue`.headwayMonitoringWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_HEADWAYMONITORINGWARNING)
    private Integer headwayMonitoringWarning;

    /**
     * This field corresponds to the database column `time_span_fatigue`.urbanForwardCollisionWarning
     */
    private static final String PROPERTY_URBANFORWARDCOLLISIONWARNING = "urbanForwardCollisionWarning";

    /**
     * This field corresponds to the database column `time_span_fatigue`.urbanForwardCollisionWarning
     */
    private static final String PROPERTY_REMARK_URBANFORWARDCOLLISIONWARNING = "城市前碰撞";

    /**
     * This field corresponds to the database column `time_span_fatigue`.urbanForwardCollisionWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_URBANFORWARDCOLLISIONWARNING)
    private Integer urbanForwardCollisionWarning;

    /**
     * This field corresponds to the database column `time_span_fatigue`.forwardCollisionWarning
     */
    private static final String PROPERTY_FORWARDCOLLISIONWARNING = "forwardCollisionWarning";

    /**
     * This field corresponds to the database column `time_span_fatigue`.forwardCollisionWarning
     */
    private static final String PROPERTY_REMARK_FORWARDCOLLISIONWARNING = "车辆前部碰撞";

    /**
     * This field corresponds to the database column `time_span_fatigue`.forwardCollisionWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FORWARDCOLLISIONWARNING)
    private Integer forwardCollisionWarning;

    /**
     * This field corresponds to the database column `time_span_fatigue`.overSpeedWarning
     */
    private static final String PROPERTY_OVERSPEEDWARNING = "overSpeedWarning";

    /**
     * This field corresponds to the database column `time_span_fatigue`.overSpeedWarning
     */
    private static final String PROPERTY_REMARK_OVERSPEEDWARNING = "限速警示";

    /**
     * This field corresponds to the database column `time_span_fatigue`.overSpeedWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_OVERSPEEDWARNING)
    private Integer overSpeedWarning;

    /**
     * This field corresponds to the database column `time_span_fatigue`.leftLaneDepartureWarning
     */
    private static final String PROPERTY_LEFTLANEDEPARTUREWARNING = "leftLaneDepartureWarning";

    /**
     * This field corresponds to the database column `time_span_fatigue`.leftLaneDepartureWarning
     */
    private static final String PROPERTY_REMARK_LEFTLANEDEPARTUREWARNING = "左车道偏离";

    /**
     * This field corresponds to the database column `time_span_fatigue`.leftLaneDepartureWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LEFTLANEDEPARTUREWARNING)
    private Integer leftLaneDepartureWarning;

    /**
     * This field corresponds to the database column `time_span_fatigue`.rightLaneDepartureWarning
     */
    private static final String PROPERTY_RIGHTLANEDEPARTUREWARNING = "rightLaneDepartureWarning";

    /**
     * This field corresponds to the database column `time_span_fatigue`.rightLaneDepartureWarning
     */
    private static final String PROPERTY_REMARK_RIGHTLANEDEPARTUREWARNING = "右车道偏离";

    /**
     * This field corresponds to the database column `time_span_fatigue`.rightLaneDepartureWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_RIGHTLANEDEPARTUREWARNING)
    private Integer rightLaneDepartureWarning;

    /**
     * This method returns the value of the database column `time_span_fatigue`.driving_span
     *
     * @return the value of `time_span_fatigue`.driving_span
     */
    public Integer getDrivingSpan() {
        return drivingSpan;
    }

    /**
     * This method sets the value of the database column `time_span_fatigue`.driving_span
     *
     * @param drivingSpan the value for `time_span_fatigue`.driving_span
     */
    public void setDrivingSpan(Integer drivingSpan) {
        this.drivingSpan = drivingSpan;
    }

    /**
     * This method returns the value of the database column `time_span_fatigue`.headwayMonitoringWarning
     *
     * @return the value of `time_span_fatigue`.headwayMonitoringWarning
     */
    public Integer getHeadwayMonitoringWarning() {
        return headwayMonitoringWarning;
    }

    /**
     * This method sets the value of the database column `time_span_fatigue`.headwayMonitoringWarning
     *
     * @param headwayMonitoringWarning the value for `time_span_fatigue`.headwayMonitoringWarning
     */
    public void setHeadwayMonitoringWarning(Integer headwayMonitoringWarning) {
        this.headwayMonitoringWarning = headwayMonitoringWarning;
    }

    /**
     * This method returns the value of the database column `time_span_fatigue`.urbanForwardCollisionWarning
     *
     * @return the value of `time_span_fatigue`.urbanForwardCollisionWarning
     */
    public Integer getUrbanForwardCollisionWarning() {
        return urbanForwardCollisionWarning;
    }

    /**
     * This method sets the value of the database column `time_span_fatigue`.urbanForwardCollisionWarning
     *
     * @param urbanForwardCollisionWarning the value for `time_span_fatigue`.urbanForwardCollisionWarning
     */
    public void setUrbanForwardCollisionWarning(Integer urbanForwardCollisionWarning) {
        this.urbanForwardCollisionWarning = urbanForwardCollisionWarning;
    }

    /**
     * This method returns the value of the database column `time_span_fatigue`.forwardCollisionWarning
     *
     * @return the value of `time_span_fatigue`.forwardCollisionWarning
     */
    public Integer getForwardCollisionWarning() {
        return forwardCollisionWarning;
    }

    /**
     * This method sets the value of the database column `time_span_fatigue`.forwardCollisionWarning
     *
     * @param forwardCollisionWarning the value for `time_span_fatigue`.forwardCollisionWarning
     */
    public void setForwardCollisionWarning(Integer forwardCollisionWarning) {
        this.forwardCollisionWarning = forwardCollisionWarning;
    }

    /**
     * This method returns the value of the database column `time_span_fatigue`.overSpeedWarning
     *
     * @return the value of `time_span_fatigue`.overSpeedWarning
     */
    public Integer getOverSpeedWarning() {
        return overSpeedWarning;
    }

    /**
     * This method sets the value of the database column `time_span_fatigue`.overSpeedWarning
     *
     * @param overSpeedWarning the value for `time_span_fatigue`.overSpeedWarning
     */
    public void setOverSpeedWarning(Integer overSpeedWarning) {
        this.overSpeedWarning = overSpeedWarning;
    }

    /**
     * This method returns the value of the database column `time_span_fatigue`.leftLaneDepartureWarning
     *
     * @return the value of `time_span_fatigue`.leftLaneDepartureWarning
     */
    public Integer getLeftLaneDepartureWarning() {
        return leftLaneDepartureWarning;
    }

    /**
     * This method sets the value of the database column `time_span_fatigue`.leftLaneDepartureWarning
     *
     * @param leftLaneDepartureWarning the value for `time_span_fatigue`.leftLaneDepartureWarning
     */
    public void setLeftLaneDepartureWarning(Integer leftLaneDepartureWarning) {
        this.leftLaneDepartureWarning = leftLaneDepartureWarning;
    }

    /**
     * This method returns the value of the database column `time_span_fatigue`.rightLaneDepartureWarning
     *
     * @return the value of `time_span_fatigue`.rightLaneDepartureWarning
     */
    public Integer getRightLaneDepartureWarning() {
        return rightLaneDepartureWarning;
    }

    /**
     * This method sets the value of the database column `time_span_fatigue`.rightLaneDepartureWarning
     *
     * @param rightLaneDepartureWarning the value for `time_span_fatigue`.rightLaneDepartureWarning
     */
    public void setRightLaneDepartureWarning(Integer rightLaneDepartureWarning) {
        this.rightLaneDepartureWarning = rightLaneDepartureWarning;
    }
}