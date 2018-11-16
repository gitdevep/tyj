/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_condition_base_score`
 */
public abstract class ConditionBaseScoreBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_condition_base_score`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.id
     */
    private static final String PROPERTY_REMARK_ID = "主键ID";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.flag_type
     */
    private static final String PROPERTY_FLAGTYPE = "flagType";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.flag_type
     */
    private static final String PROPERTY_REMARK_FLAGTYPE = "条件类型标志";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.flag_type
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FLAGTYPE)
    private Integer flagType;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_front_collide
     */
    private static final String PROPERTY_CARFRONTCOLLIDE = "carFrontCollide";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_front_collide
     */
    private static final String PROPERTY_REMARK_CARFRONTCOLLIDE = "车辆前部碰撞";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARFRONTCOLLIDE)
    private Integer carFrontCollide;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.limit_speed_alarm
     */
    private static final String PROPERTY_LIMITSPEEDALARM = "limitSpeedAlarm";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.limit_speed_alarm
     */
    private static final String PROPERTY_REMARK_LIMITSPEEDALARM = "限速警示";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.limit_speed_alarm
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LIMITSPEEDALARM)
    private Integer limitSpeedAlarm;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.left_lane_deviate
     */
    private static final String PROPERTY_LEFTLANEDEVIATE = "leftLaneDeviate";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.left_lane_deviate
     */
    private static final String PROPERTY_REMARK_LEFTLANEDEVIATE = "左车道偏离";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.left_lane_deviate
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LEFTLANEDEVIATE)
    private Integer leftLaneDeviate;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.city_front_collide
     */
    private static final String PROPERTY_CITYFRONTCOLLIDE = "cityFrontCollide";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.city_front_collide
     */
    private static final String PROPERTY_REMARK_CITYFRONTCOLLIDE = "城市前碰撞";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.city_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CITYFRONTCOLLIDE)
    private Integer cityFrontCollide;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_distance_monitor
     */
    private static final String PROPERTY_CARDISTANCEMONITOR = "carDistanceMonitor";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_distance_monitor
     */
    private static final String PROPERTY_REMARK_CARDISTANCEMONITOR = "车距监测";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_distance_monitor
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARDISTANCEMONITOR)
    private Integer carDistanceMonitor;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.right_lane_deviate
     */
    private static final String PROPERTY_RIGHTLANEDEVIATE = "rightLaneDeviate";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.right_lane_deviate
     */
    private static final String PROPERTY_REMARK_RIGHTLANEDEVIATE = "右车道偏离";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.right_lane_deviate
     */
    @ColumnDescription(desc = PROPERTY_REMARK_RIGHTLANEDEVIATE)
    private Integer rightLaneDeviate;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_start
     */
    private static final String PROPERTY_CARSTART = "carStart";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_start
     */
    private static final String PROPERTY_REMARK_CARSTART = "汽车启动";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_start
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARSTART)
    private Integer carStart;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_end
     */
    private static final String PROPERTY_CAREND = "carEnd";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_end
     */
    private static final String PROPERTY_REMARK_CAREND = "汽车熄火";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_end
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CAREND)
    private Integer carEnd;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.speed_up
     */
    private static final String PROPERTY_SPEEDUP = "speedUp";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.speed_up
     */
    private static final String PROPERTY_REMARK_SPEEDUP = "急加速";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.speed_up
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SPEEDUP)
    private Integer speedUp;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.speed_down
     */
    private static final String PROPERTY_SPEEDDOWN = "speedDown";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.speed_down
     */
    private static final String PROPERTY_REMARK_SPEEDDOWN = "急减速";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.speed_down
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SPEEDDOWN)
    private Integer speedDown;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.person_front_collide
     */
    private static final String PROPERTY_PERSONFRONTCOLLIDE = "personFrontCollide";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.person_front_collide
     */
    private static final String PROPERTY_REMARK_PERSONFRONTCOLLIDE = "行人前部碰撞";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.person_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PERSONFRONTCOLLIDE)
    private Integer personFrontCollide;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.collide_follow
     */
    private static final String PROPERTY_COLLIDEFOLLOW = "collideFollow";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.collide_follow
     */
    private static final String PROPERTY_REMARK_COLLIDEFOLLOW = "碰撞跟踪";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.collide_follow
     */
    @ColumnDescription(desc = PROPERTY_REMARK_COLLIDEFOLLOW)
    private Integer collideFollow;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_collide_follow
     */
    private static final String PROPERTY_CARCOLLIDEFOLLOW = "carCollideFollow";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_collide_follow
     */
    private static final String PROPERTY_REMARK_CARCOLLIDEFOLLOW = "车辆前部碰撞跟踪";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.car_collide_follow
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARCOLLIDEFOLLOW)
    private Integer carCollideFollow;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.person_collide_follow
     */
    private static final String PROPERTY_PERSONCOLLIDEFOLLOW = "personCollideFollow";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.person_collide_follow
     */
    private static final String PROPERTY_REMARK_PERSONCOLLIDEFOLLOW = "行人前部碰撞跟踪";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.person_collide_follow
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PERSONCOLLIDEFOLLOW)
    private Integer personCollideFollow;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.one_car_front_collide
     */
    private static final String PROPERTY_ONECARFRONTCOLLIDE = "oneCarFrontCollide";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.one_car_front_collide
     */
    private static final String PROPERTY_REMARK_ONECARFRONTCOLLIDE = "一类车辆前部碰撞";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.one_car_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ONECARFRONTCOLLIDE)
    private Integer oneCarFrontCollide;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.two_car_front_collide
     */
    private static final String PROPERTY_TWOCARFRONTCOLLIDE = "twoCarFrontCollide";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.two_car_front_collide
     */
    private static final String PROPERTY_REMARK_TWOCARFRONTCOLLIDE = "二类车辆前部碰撞";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.two_car_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_TWOCARFRONTCOLLIDE)
    private Integer twoCarFrontCollide;

    /**
     * This field corresponds to the database column `tb_condition_base_score`.description
     */
    private static final String PROPERTY_DESCRIPTION = "description";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.description
     */
    private static final String PROPERTY_REMARK_DESCRIPTION = "描述";

    /**
     * This field corresponds to the database column `tb_condition_base_score`.description
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DESCRIPTION)
    private String description;

    /**
     * This method returns the value of the database column `tb_condition_base_score`.id
     *
     * @return the value of `tb_condition_base_score`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.id
     *
     * @param id the value for `tb_condition_base_score`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.flag_type
     *
     * @return the value of `tb_condition_base_score`.flag_type
     */
    public Integer getFlagType() {
        return flagType;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.flag_type
     *
     * @param flagType the value for `tb_condition_base_score`.flag_type
     */
    public void setFlagType(Integer flagType) {
        this.flagType = flagType;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.car_front_collide
     *
     * @return the value of `tb_condition_base_score`.car_front_collide
     */
    public Integer getCarFrontCollide() {
        return carFrontCollide;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.car_front_collide
     *
     * @param carFrontCollide the value for `tb_condition_base_score`.car_front_collide
     */
    public void setCarFrontCollide(Integer carFrontCollide) {
        this.carFrontCollide = carFrontCollide;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.limit_speed_alarm
     *
     * @return the value of `tb_condition_base_score`.limit_speed_alarm
     */
    public Integer getLimitSpeedAlarm() {
        return limitSpeedAlarm;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.limit_speed_alarm
     *
     * @param limitSpeedAlarm the value for `tb_condition_base_score`.limit_speed_alarm
     */
    public void setLimitSpeedAlarm(Integer limitSpeedAlarm) {
        this.limitSpeedAlarm = limitSpeedAlarm;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.left_lane_deviate
     *
     * @return the value of `tb_condition_base_score`.left_lane_deviate
     */
    public Integer getLeftLaneDeviate() {
        return leftLaneDeviate;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.left_lane_deviate
     *
     * @param leftLaneDeviate the value for `tb_condition_base_score`.left_lane_deviate
     */
    public void setLeftLaneDeviate(Integer leftLaneDeviate) {
        this.leftLaneDeviate = leftLaneDeviate;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.city_front_collide
     *
     * @return the value of `tb_condition_base_score`.city_front_collide
     */
    public Integer getCityFrontCollide() {
        return cityFrontCollide;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.city_front_collide
     *
     * @param cityFrontCollide the value for `tb_condition_base_score`.city_front_collide
     */
    public void setCityFrontCollide(Integer cityFrontCollide) {
        this.cityFrontCollide = cityFrontCollide;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.car_distance_monitor
     *
     * @return the value of `tb_condition_base_score`.car_distance_monitor
     */
    public Integer getCarDistanceMonitor() {
        return carDistanceMonitor;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.car_distance_monitor
     *
     * @param carDistanceMonitor the value for `tb_condition_base_score`.car_distance_monitor
     */
    public void setCarDistanceMonitor(Integer carDistanceMonitor) {
        this.carDistanceMonitor = carDistanceMonitor;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.right_lane_deviate
     *
     * @return the value of `tb_condition_base_score`.right_lane_deviate
     */
    public Integer getRightLaneDeviate() {
        return rightLaneDeviate;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.right_lane_deviate
     *
     * @param rightLaneDeviate the value for `tb_condition_base_score`.right_lane_deviate
     */
    public void setRightLaneDeviate(Integer rightLaneDeviate) {
        this.rightLaneDeviate = rightLaneDeviate;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.car_start
     *
     * @return the value of `tb_condition_base_score`.car_start
     */
    public Integer getCarStart() {
        return carStart;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.car_start
     *
     * @param carStart the value for `tb_condition_base_score`.car_start
     */
    public void setCarStart(Integer carStart) {
        this.carStart = carStart;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.car_end
     *
     * @return the value of `tb_condition_base_score`.car_end
     */
    public Integer getCarEnd() {
        return carEnd;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.car_end
     *
     * @param carEnd the value for `tb_condition_base_score`.car_end
     */
    public void setCarEnd(Integer carEnd) {
        this.carEnd = carEnd;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.speed_up
     *
     * @return the value of `tb_condition_base_score`.speed_up
     */
    public Integer getSpeedUp() {
        return speedUp;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.speed_up
     *
     * @param speedUp the value for `tb_condition_base_score`.speed_up
     */
    public void setSpeedUp(Integer speedUp) {
        this.speedUp = speedUp;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.speed_down
     *
     * @return the value of `tb_condition_base_score`.speed_down
     */
    public Integer getSpeedDown() {
        return speedDown;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.speed_down
     *
     * @param speedDown the value for `tb_condition_base_score`.speed_down
     */
    public void setSpeedDown(Integer speedDown) {
        this.speedDown = speedDown;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.person_front_collide
     *
     * @return the value of `tb_condition_base_score`.person_front_collide
     */
    public Integer getPersonFrontCollide() {
        return personFrontCollide;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.person_front_collide
     *
     * @param personFrontCollide the value for `tb_condition_base_score`.person_front_collide
     */
    public void setPersonFrontCollide(Integer personFrontCollide) {
        this.personFrontCollide = personFrontCollide;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.collide_follow
     *
     * @return the value of `tb_condition_base_score`.collide_follow
     */
    public Integer getCollideFollow() {
        return collideFollow;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.collide_follow
     *
     * @param collideFollow the value for `tb_condition_base_score`.collide_follow
     */
    public void setCollideFollow(Integer collideFollow) {
        this.collideFollow = collideFollow;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.car_collide_follow
     *
     * @return the value of `tb_condition_base_score`.car_collide_follow
     */
    public Integer getCarCollideFollow() {
        return carCollideFollow;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.car_collide_follow
     *
     * @param carCollideFollow the value for `tb_condition_base_score`.car_collide_follow
     */
    public void setCarCollideFollow(Integer carCollideFollow) {
        this.carCollideFollow = carCollideFollow;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.person_collide_follow
     *
     * @return the value of `tb_condition_base_score`.person_collide_follow
     */
    public Integer getPersonCollideFollow() {
        return personCollideFollow;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.person_collide_follow
     *
     * @param personCollideFollow the value for `tb_condition_base_score`.person_collide_follow
     */
    public void setPersonCollideFollow(Integer personCollideFollow) {
        this.personCollideFollow = personCollideFollow;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.one_car_front_collide
     *
     * @return the value of `tb_condition_base_score`.one_car_front_collide
     */
    public Integer getOneCarFrontCollide() {
        return oneCarFrontCollide;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.one_car_front_collide
     *
     * @param oneCarFrontCollide the value for `tb_condition_base_score`.one_car_front_collide
     */
    public void setOneCarFrontCollide(Integer oneCarFrontCollide) {
        this.oneCarFrontCollide = oneCarFrontCollide;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.two_car_front_collide
     *
     * @return the value of `tb_condition_base_score`.two_car_front_collide
     */
    public Integer getTwoCarFrontCollide() {
        return twoCarFrontCollide;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.two_car_front_collide
     *
     * @param twoCarFrontCollide the value for `tb_condition_base_score`.two_car_front_collide
     */
    public void setTwoCarFrontCollide(Integer twoCarFrontCollide) {
        this.twoCarFrontCollide = twoCarFrontCollide;
    }

    /**
     * This method returns the value of the database column `tb_condition_base_score`.description
     *
     * @return the value of `tb_condition_base_score`.description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the value of the database column `tb_condition_base_score`.description
     *
     * @param description the value for `tb_condition_base_score`.description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}