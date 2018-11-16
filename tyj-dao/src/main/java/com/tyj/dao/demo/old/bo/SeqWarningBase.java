/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.old.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `seq_warning`
 */
public abstract class SeqWarningBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `seq_warning`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `seq_warning`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `seq_warning`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `seq_warning`.headwayMonitoringWarning
     */
    private static final String PROPERTY_HEADWAYMONITORINGWARNING = "headwayMonitoringWarning";

    /**
     * This field corresponds to the database column `seq_warning`.headwayMonitoringWarning
     */
    private static final String PROPERTY_REMARK_HEADWAYMONITORINGWARNING = "车距监测";

    /**
     * This field corresponds to the database column `seq_warning`.headwayMonitoringWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_HEADWAYMONITORINGWARNING)
    private Integer headwayMonitoringWarning;

    /**
     * This field corresponds to the database column `seq_warning`.urbanForwardCollisionWarning
     */
    private static final String PROPERTY_URBANFORWARDCOLLISIONWARNING = "urbanForwardCollisionWarning";

    /**
     * This field corresponds to the database column `seq_warning`.urbanForwardCollisionWarning
     */
    private static final String PROPERTY_REMARK_URBANFORWARDCOLLISIONWARNING = "城市前碰撞";

    /**
     * This field corresponds to the database column `seq_warning`.urbanForwardCollisionWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_URBANFORWARDCOLLISIONWARNING)
    private Integer urbanForwardCollisionWarning;

    /**
     * This field corresponds to the database column `seq_warning`.forwardCollisionWarning
     */
    private static final String PROPERTY_FORWARDCOLLISIONWARNING = "forwardCollisionWarning";

    /**
     * This field corresponds to the database column `seq_warning`.forwardCollisionWarning
     */
    private static final String PROPERTY_REMARK_FORWARDCOLLISIONWARNING = "车辆前部碰撞";

    /**
     * This field corresponds to the database column `seq_warning`.forwardCollisionWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FORWARDCOLLISIONWARNING)
    private Integer forwardCollisionWarning;

    /**
     * This field corresponds to the database column `seq_warning`.overSpeedWarning
     */
    private static final String PROPERTY_OVERSPEEDWARNING = "overSpeedWarning";

    /**
     * This field corresponds to the database column `seq_warning`.overSpeedWarning
     */
    private static final String PROPERTY_REMARK_OVERSPEEDWARNING = "限速警示";

    /**
     * This field corresponds to the database column `seq_warning`.overSpeedWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_OVERSPEEDWARNING)
    private Integer overSpeedWarning;

    /**
     * This field corresponds to the database column `seq_warning`.leftLaneDepartureWarning
     */
    private static final String PROPERTY_LEFTLANEDEPARTUREWARNING = "leftLaneDepartureWarning";

    /**
     * This field corresponds to the database column `seq_warning`.leftLaneDepartureWarning
     */
    private static final String PROPERTY_REMARK_LEFTLANEDEPARTUREWARNING = "左车道偏离";

    /**
     * This field corresponds to the database column `seq_warning`.leftLaneDepartureWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LEFTLANEDEPARTUREWARNING)
    private Integer leftLaneDepartureWarning;

    /**
     * This field corresponds to the database column `seq_warning`.rightLaneDepartureWarning
     */
    private static final String PROPERTY_RIGHTLANEDEPARTUREWARNING = "rightLaneDepartureWarning";

    /**
     * This field corresponds to the database column `seq_warning`.rightLaneDepartureWarning
     */
    private static final String PROPERTY_REMARK_RIGHTLANEDEPARTUREWARNING = "右车道偏离";

    /**
     * This field corresponds to the database column `seq_warning`.rightLaneDepartureWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_RIGHTLANEDEPARTUREWARNING)
    private Integer rightLaneDepartureWarning;

    /**
     * This field corresponds to the database column `seq_warning`.description
     */
    private static final String PROPERTY_DESCRIPTION = "description";

    /**
     * This field corresponds to the database column `seq_warning`.description
     */
    private static final String PROPERTY_REMARK_DESCRIPTION = "描述";

    /**
     * This field corresponds to the database column `seq_warning`.description
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DESCRIPTION)
    private String description;

    /**
     * This method returns the value of the database column `seq_warning`.id
     *
     * @return the value of `seq_warning`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `seq_warning`.id
     *
     * @param id the value for `seq_warning`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `seq_warning`.headwayMonitoringWarning
     *
     * @return the value of `seq_warning`.headwayMonitoringWarning
     */
    public Integer getHeadwayMonitoringWarning() {
        return headwayMonitoringWarning;
    }

    /**
     * This method sets the value of the database column `seq_warning`.headwayMonitoringWarning
     *
     * @param headwayMonitoringWarning the value for `seq_warning`.headwayMonitoringWarning
     */
    public void setHeadwayMonitoringWarning(Integer headwayMonitoringWarning) {
        this.headwayMonitoringWarning = headwayMonitoringWarning;
    }

    /**
     * This method returns the value of the database column `seq_warning`.urbanForwardCollisionWarning
     *
     * @return the value of `seq_warning`.urbanForwardCollisionWarning
     */
    public Integer getUrbanForwardCollisionWarning() {
        return urbanForwardCollisionWarning;
    }

    /**
     * This method sets the value of the database column `seq_warning`.urbanForwardCollisionWarning
     *
     * @param urbanForwardCollisionWarning the value for `seq_warning`.urbanForwardCollisionWarning
     */
    public void setUrbanForwardCollisionWarning(Integer urbanForwardCollisionWarning) {
        this.urbanForwardCollisionWarning = urbanForwardCollisionWarning;
    }

    /**
     * This method returns the value of the database column `seq_warning`.forwardCollisionWarning
     *
     * @return the value of `seq_warning`.forwardCollisionWarning
     */
    public Integer getForwardCollisionWarning() {
        return forwardCollisionWarning;
    }

    /**
     * This method sets the value of the database column `seq_warning`.forwardCollisionWarning
     *
     * @param forwardCollisionWarning the value for `seq_warning`.forwardCollisionWarning
     */
    public void setForwardCollisionWarning(Integer forwardCollisionWarning) {
        this.forwardCollisionWarning = forwardCollisionWarning;
    }

    /**
     * This method returns the value of the database column `seq_warning`.overSpeedWarning
     *
     * @return the value of `seq_warning`.overSpeedWarning
     */
    public Integer getOverSpeedWarning() {
        return overSpeedWarning;
    }

    /**
     * This method sets the value of the database column `seq_warning`.overSpeedWarning
     *
     * @param overSpeedWarning the value for `seq_warning`.overSpeedWarning
     */
    public void setOverSpeedWarning(Integer overSpeedWarning) {
        this.overSpeedWarning = overSpeedWarning;
    }

    /**
     * This method returns the value of the database column `seq_warning`.leftLaneDepartureWarning
     *
     * @return the value of `seq_warning`.leftLaneDepartureWarning
     */
    public Integer getLeftLaneDepartureWarning() {
        return leftLaneDepartureWarning;
    }

    /**
     * This method sets the value of the database column `seq_warning`.leftLaneDepartureWarning
     *
     * @param leftLaneDepartureWarning the value for `seq_warning`.leftLaneDepartureWarning
     */
    public void setLeftLaneDepartureWarning(Integer leftLaneDepartureWarning) {
        this.leftLaneDepartureWarning = leftLaneDepartureWarning;
    }

    /**
     * This method returns the value of the database column `seq_warning`.rightLaneDepartureWarning
     *
     * @return the value of `seq_warning`.rightLaneDepartureWarning
     */
    public Integer getRightLaneDepartureWarning() {
        return rightLaneDepartureWarning;
    }

    /**
     * This method sets the value of the database column `seq_warning`.rightLaneDepartureWarning
     *
     * @param rightLaneDepartureWarning the value for `seq_warning`.rightLaneDepartureWarning
     */
    public void setRightLaneDepartureWarning(Integer rightLaneDepartureWarning) {
        this.rightLaneDepartureWarning = rightLaneDepartureWarning;
    }

    /**
     * This method returns the value of the database column `seq_warning`.description
     *
     * @return the value of `seq_warning`.description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the value of the database column `seq_warning`.description
     *
     * @param description the value for `seq_warning`.description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}