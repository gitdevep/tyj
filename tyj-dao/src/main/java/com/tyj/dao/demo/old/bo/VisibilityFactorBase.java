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
 * This class corresponds to the database table `visibility_factor`
 */
public abstract class VisibilityFactorBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `visibility_factor`.range_start
     */
    private static final String PROPERTY_RANGESTART = "rangeStart";

    /**
     * This field corresponds to the database column `visibility_factor`.range_start
     */
    private static final String PROPERTY_REMARK_RANGESTART = "开始时间";

    /**
     * This field corresponds to the database column `visibility_factor`.range_start
     */
    @ColumnDescription(desc = PROPERTY_REMARK_RANGESTART)
    @Id
    private Date rangeStart;

    /**
     * This field corresponds to the database column `visibility_factor`.range_end
     */
    private static final String PROPERTY_RANGEEND = "rangeEnd";

    /**
     * This field corresponds to the database column `visibility_factor`.range_end
     */
    private static final String PROPERTY_REMARK_RANGEEND = "结束时间";

    /**
     * This field corresponds to the database column `visibility_factor`.range_end
     */
    @ColumnDescription(desc = PROPERTY_REMARK_RANGEEND)
    @Id
    private Date rangeEnd;

    /**
     * This field corresponds to the database column `visibility_factor`.headwayMonitoringWarning
     */
    private static final String PROPERTY_HEADWAYMONITORINGWARNING = "headwayMonitoringWarning";

    /**
     * This field corresponds to the database column `visibility_factor`.headwayMonitoringWarning
     */
    private static final String PROPERTY_REMARK_HEADWAYMONITORINGWARNING = "车距监测";

    /**
     * This field corresponds to the database column `visibility_factor`.headwayMonitoringWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_HEADWAYMONITORINGWARNING)
    private Integer headwayMonitoringWarning;

    /**
     * This field corresponds to the database column `visibility_factor`.urbanForwardCollisionWarning
     */
    private static final String PROPERTY_URBANFORWARDCOLLISIONWARNING = "urbanForwardCollisionWarning";

    /**
     * This field corresponds to the database column `visibility_factor`.urbanForwardCollisionWarning
     */
    private static final String PROPERTY_REMARK_URBANFORWARDCOLLISIONWARNING = "城市前碰撞";

    /**
     * This field corresponds to the database column `visibility_factor`.urbanForwardCollisionWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_URBANFORWARDCOLLISIONWARNING)
    private Integer urbanForwardCollisionWarning;

    /**
     * This field corresponds to the database column `visibility_factor`.forwardCollisionWarning
     */
    private static final String PROPERTY_FORWARDCOLLISIONWARNING = "forwardCollisionWarning";

    /**
     * This field corresponds to the database column `visibility_factor`.forwardCollisionWarning
     */
    private static final String PROPERTY_REMARK_FORWARDCOLLISIONWARNING = "车辆前部碰撞";

    /**
     * This field corresponds to the database column `visibility_factor`.forwardCollisionWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FORWARDCOLLISIONWARNING)
    private Integer forwardCollisionWarning;

    /**
     * This field corresponds to the database column `visibility_factor`.overSpeedWarning
     */
    private static final String PROPERTY_OVERSPEEDWARNING = "overSpeedWarning";

    /**
     * This field corresponds to the database column `visibility_factor`.overSpeedWarning
     */
    private static final String PROPERTY_REMARK_OVERSPEEDWARNING = "限速警示";

    /**
     * This field corresponds to the database column `visibility_factor`.overSpeedWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_OVERSPEEDWARNING)
    private Integer overSpeedWarning;

    /**
     * This field corresponds to the database column `visibility_factor`.leftLaneDepartureWarning
     */
    private static final String PROPERTY_LEFTLANEDEPARTUREWARNING = "leftLaneDepartureWarning";

    /**
     * This field corresponds to the database column `visibility_factor`.leftLaneDepartureWarning
     */
    private static final String PROPERTY_REMARK_LEFTLANEDEPARTUREWARNING = "左车道偏离";

    /**
     * This field corresponds to the database column `visibility_factor`.leftLaneDepartureWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LEFTLANEDEPARTUREWARNING)
    private Integer leftLaneDepartureWarning;

    /**
     * This field corresponds to the database column `visibility_factor`.rightLaneDepartureWarning
     */
    private static final String PROPERTY_RIGHTLANEDEPARTUREWARNING = "rightLaneDepartureWarning";

    /**
     * This field corresponds to the database column `visibility_factor`.rightLaneDepartureWarning
     */
    private static final String PROPERTY_REMARK_RIGHTLANEDEPARTUREWARNING = "右车道偏离";

    /**
     * This field corresponds to the database column `visibility_factor`.rightLaneDepartureWarning
     */
    @ColumnDescription(desc = PROPERTY_REMARK_RIGHTLANEDEPARTUREWARNING)
    private Integer rightLaneDepartureWarning;

    /**
     * This method returns the value of the database column `visibility_factor`.range_start
     *
     * @return the value of `visibility_factor`.range_start
     */
    public Date getRangeStart() {
        return rangeStart;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.range_start
     *
     * @param rangeStart the value for `visibility_factor`.range_start
     */
    public void setRangeStart(Date rangeStart) {
        this.rangeStart = rangeStart;
    }

    /**
     * This method returns the value of the database column `visibility_factor`.range_end
     *
     * @return the value of `visibility_factor`.range_end
     */
    public Date getRangeEnd() {
        return rangeEnd;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.range_end
     *
     * @param rangeEnd the value for `visibility_factor`.range_end
     */
    public void setRangeEnd(Date rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    /**
     * This method returns the value of the database column `visibility_factor`.headwayMonitoringWarning
     *
     * @return the value of `visibility_factor`.headwayMonitoringWarning
     */
    public Integer getHeadwayMonitoringWarning() {
        return headwayMonitoringWarning;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.headwayMonitoringWarning
     *
     * @param headwayMonitoringWarning the value for `visibility_factor`.headwayMonitoringWarning
     */
    public void setHeadwayMonitoringWarning(Integer headwayMonitoringWarning) {
        this.headwayMonitoringWarning = headwayMonitoringWarning;
    }

    /**
     * This method returns the value of the database column `visibility_factor`.urbanForwardCollisionWarning
     *
     * @return the value of `visibility_factor`.urbanForwardCollisionWarning
     */
    public Integer getUrbanForwardCollisionWarning() {
        return urbanForwardCollisionWarning;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.urbanForwardCollisionWarning
     *
     * @param urbanForwardCollisionWarning the value for `visibility_factor`.urbanForwardCollisionWarning
     */
    public void setUrbanForwardCollisionWarning(Integer urbanForwardCollisionWarning) {
        this.urbanForwardCollisionWarning = urbanForwardCollisionWarning;
    }

    /**
     * This method returns the value of the database column `visibility_factor`.forwardCollisionWarning
     *
     * @return the value of `visibility_factor`.forwardCollisionWarning
     */
    public Integer getForwardCollisionWarning() {
        return forwardCollisionWarning;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.forwardCollisionWarning
     *
     * @param forwardCollisionWarning the value for `visibility_factor`.forwardCollisionWarning
     */
    public void setForwardCollisionWarning(Integer forwardCollisionWarning) {
        this.forwardCollisionWarning = forwardCollisionWarning;
    }

    /**
     * This method returns the value of the database column `visibility_factor`.overSpeedWarning
     *
     * @return the value of `visibility_factor`.overSpeedWarning
     */
    public Integer getOverSpeedWarning() {
        return overSpeedWarning;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.overSpeedWarning
     *
     * @param overSpeedWarning the value for `visibility_factor`.overSpeedWarning
     */
    public void setOverSpeedWarning(Integer overSpeedWarning) {
        this.overSpeedWarning = overSpeedWarning;
    }

    /**
     * This method returns the value of the database column `visibility_factor`.leftLaneDepartureWarning
     *
     * @return the value of `visibility_factor`.leftLaneDepartureWarning
     */
    public Integer getLeftLaneDepartureWarning() {
        return leftLaneDepartureWarning;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.leftLaneDepartureWarning
     *
     * @param leftLaneDepartureWarning the value for `visibility_factor`.leftLaneDepartureWarning
     */
    public void setLeftLaneDepartureWarning(Integer leftLaneDepartureWarning) {
        this.leftLaneDepartureWarning = leftLaneDepartureWarning;
    }

    /**
     * This method returns the value of the database column `visibility_factor`.rightLaneDepartureWarning
     *
     * @return the value of `visibility_factor`.rightLaneDepartureWarning
     */
    public Integer getRightLaneDepartureWarning() {
        return rightLaneDepartureWarning;
    }

    /**
     * This method sets the value of the database column `visibility_factor`.rightLaneDepartureWarning
     *
     * @param rightLaneDepartureWarning the value for `visibility_factor`.rightLaneDepartureWarning
     */
    public void setRightLaneDepartureWarning(Integer rightLaneDepartureWarning) {
        this.rightLaneDepartureWarning = rightLaneDepartureWarning;
    }
}