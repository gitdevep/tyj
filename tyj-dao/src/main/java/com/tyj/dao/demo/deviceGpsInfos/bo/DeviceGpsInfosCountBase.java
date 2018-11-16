/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `device_gps_infos_count`
 */
public abstract class DeviceGpsInfosCountBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `device_gps_infos_count`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.id
     */
    private static final String PROPERTY_REMARK_ID = "ID";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_id
     */
    private static final String PROPERTY_DEVICEID = "deviceId";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_id
     */
    private static final String PROPERTY_REMARK_DEVICEID = "设备编号";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICEID)
    private Integer deviceId;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.count_date
     */
    private static final String PROPERTY_COUNTDATE = "countDate";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.count_date
     */
    private static final String PROPERTY_REMARK_COUNTDATE = "统计时间";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.count_date
     */
    @ColumnDescription(desc = PROPERTY_REMARK_COUNTDATE)
    private Date countDate;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.drive_time
     */
    private static final String PROPERTY_DRIVETIME = "driveTime";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.drive_time
     */
    private static final String PROPERTY_REMARK_DRIVETIME = "开车时长";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.drive_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DRIVETIME)
    private Double driveTime;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_front_collide
     */
    private static final String PROPERTY_CARFRONTCOLLIDE = "carFrontCollide";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_front_collide
     */
    private static final String PROPERTY_REMARK_CARFRONTCOLLIDE = "车辆前部碰撞";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARFRONTCOLLIDE)
    private Integer carFrontCollide;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.limit_speed_alarm
     */
    private static final String PROPERTY_LIMITSPEEDALARM = "limitSpeedAlarm";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.limit_speed_alarm
     */
    private static final String PROPERTY_REMARK_LIMITSPEEDALARM = "限速警示";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.limit_speed_alarm
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LIMITSPEEDALARM)
    private Integer limitSpeedAlarm;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.left_lane_deviate
     */
    private static final String PROPERTY_LEFTLANEDEVIATE = "leftLaneDeviate";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.left_lane_deviate
     */
    private static final String PROPERTY_REMARK_LEFTLANEDEVIATE = "左车道偏离";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.left_lane_deviate
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LEFTLANEDEVIATE)
    private Integer leftLaneDeviate;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.city_front_collide
     */
    private static final String PROPERTY_CITYFRONTCOLLIDE = "cityFrontCollide";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.city_front_collide
     */
    private static final String PROPERTY_REMARK_CITYFRONTCOLLIDE = "城市前碰撞";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.city_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CITYFRONTCOLLIDE)
    private Integer cityFrontCollide;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_distance_monitor
     */
    private static final String PROPERTY_CARDISTANCEMONITOR = "carDistanceMonitor";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_distance_monitor
     */
    private static final String PROPERTY_REMARK_CARDISTANCEMONITOR = "车距监测";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_distance_monitor
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARDISTANCEMONITOR)
    private Integer carDistanceMonitor;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.right_lane_deviate
     */
    private static final String PROPERTY_RIGHTLANEDEVIATE = "rightLaneDeviate";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.right_lane_deviate
     */
    private static final String PROPERTY_REMARK_RIGHTLANEDEVIATE = "右车道偏离";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.right_lane_deviate
     */
    @ColumnDescription(desc = PROPERTY_REMARK_RIGHTLANEDEVIATE)
    private Integer rightLaneDeviate;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_start
     */
    private static final String PROPERTY_CARSTART = "carStart";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_start
     */
    private static final String PROPERTY_REMARK_CARSTART = "汽车启动";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_start
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARSTART)
    private Integer carStart;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_end
     */
    private static final String PROPERTY_CAREND = "carEnd";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_end
     */
    private static final String PROPERTY_REMARK_CAREND = "汽车熄火";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_end
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CAREND)
    private Integer carEnd;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.location_message
     */
    private static final String PROPERTY_LOCATIONMESSAGE = "locationMessage";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.location_message
     */
    private static final String PROPERTY_REMARK_LOCATIONMESSAGE = "定位信息";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.location_message
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LOCATIONMESSAGE)
    private Integer locationMessage;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.speed_up
     */
    private static final String PROPERTY_SPEEDUP = "speedUp";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.speed_up
     */
    private static final String PROPERTY_REMARK_SPEEDUP = "急加速";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.speed_up
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SPEEDUP)
    private Integer speedUp;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.speed_down
     */
    private static final String PROPERTY_SPEEDDOWN = "speedDown";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.speed_down
     */
    private static final String PROPERTY_REMARK_SPEEDDOWN = "急减速";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.speed_down
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SPEEDDOWN)
    private Integer speedDown;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.vd_no_start
     */
    private static final String PROPERTY_VDNOSTART = "vdNoStart";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.vd_no_start
     */
    private static final String PROPERTY_REMARK_VDNOSTART = "VD未启动";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.vd_no_start
     */
    @ColumnDescription(desc = PROPERTY_REMARK_VDNOSTART)
    private Integer vdNoStart;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_active
     */
    private static final String PROPERTY_DEVICEACTIVE = "deviceActive";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_active
     */
    private static final String PROPERTY_REMARK_DEVICEACTIVE = "设备已激活";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_active
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICEACTIVE)
    private Integer deviceActive;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.person_front_collide
     */
    private static final String PROPERTY_PERSONFRONTCOLLIDE = "personFrontCollide";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.person_front_collide
     */
    private static final String PROPERTY_REMARK_PERSONFRONTCOLLIDE = "行人前部碰撞";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.person_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PERSONFRONTCOLLIDE)
    private Integer personFrontCollide;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.collide_follow
     */
    private static final String PROPERTY_COLLIDEFOLLOW = "collideFollow";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.collide_follow
     */
    private static final String PROPERTY_REMARK_COLLIDEFOLLOW = "碰撞跟踪";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.collide_follow
     */
    @ColumnDescription(desc = PROPERTY_REMARK_COLLIDEFOLLOW)
    private Integer collideFollow;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_set_success
     */
    private static final String PROPERTY_DEVICESETSUCCESS = "deviceSetSuccess";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_set_success
     */
    private static final String PROPERTY_REMARK_DEVICESETSUCCESS = "设备配置成功";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_set_success
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICESETSUCCESS)
    private Integer deviceSetSuccess;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_set_fail
     */
    private static final String PROPERTY_DEVICESETFAIL = "deviceSetFail";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_set_fail
     */
    private static final String PROPERTY_REMARK_DEVICESETFAIL = "设备配置失败";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.device_set_fail
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICESETFAIL)
    private Integer deviceSetFail;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.scores
     */
    private static final String PROPERTY_SCORES = "scores";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.scores
     */
    private static final String PROPERTY_REMARK_SCORES = "平均分数";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.scores
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SCORES)
    private Double scores;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.sum
     */
    private static final String PROPERTY_SUM = "sum";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.sum
     */
    private static final String PROPERTY_REMARK_SUM = "总分数";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.sum
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SUM)
    private Double sum;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_collide_follow
     */
    private static final String PROPERTY_CARCOLLIDEFOLLOW = "carCollideFollow";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_collide_follow
     */
    private static final String PROPERTY_REMARK_CARCOLLIDEFOLLOW = "车辆前部碰撞跟踪";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.car_collide_follow
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CARCOLLIDEFOLLOW)
    private Integer carCollideFollow;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.person_collide_follow
     */
    private static final String PROPERTY_PERSONCOLLIDEFOLLOW = "personCollideFollow";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.person_collide_follow
     */
    private static final String PROPERTY_REMARK_PERSONCOLLIDEFOLLOW = "行人前部碰撞跟踪";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.person_collide_follow
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PERSONCOLLIDEFOLLOW)
    private Integer personCollideFollow;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.one_car_front_collide
     */
    private static final String PROPERTY_ONECARFRONTCOLLIDE = "oneCarFrontCollide";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.one_car_front_collide
     */
    private static final String PROPERTY_REMARK_ONECARFRONTCOLLIDE = "一类车辆前部碰撞";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.one_car_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ONECARFRONTCOLLIDE)
    private Integer oneCarFrontCollide;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.two_car_front_collide
     */
    private static final String PROPERTY_TWOCARFRONTCOLLIDE = "twoCarFrontCollide";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.two_car_front_collide
     */
    private static final String PROPERTY_REMARK_TWOCARFRONTCOLLIDE = "二类车辆前部碰撞";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.two_car_front_collide
     */
    @ColumnDescription(desc = PROPERTY_REMARK_TWOCARFRONTCOLLIDE)
    private Integer twoCarFrontCollide;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.over_speed_follow
     */
    private static final String PROPERTY_OVERSPEEDFOLLOW = "overSpeedFollow";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.over_speed_follow
     */
    private static final String PROPERTY_REMARK_OVERSPEEDFOLLOW = "超速跟踪";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.over_speed_follow
     */
    @ColumnDescription(desc = PROPERTY_REMARK_OVERSPEEDFOLLOW)
    private Integer overSpeedFollow;

    /**
     * This field corresponds to the database column `device_gps_infos_count`.over_speed_alarm
     */
    private static final String PROPERTY_OVERSPEEDALARM = "overSpeedAlarm";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.over_speed_alarm
     */
    private static final String PROPERTY_REMARK_OVERSPEEDALARM = "超速警示";

    /**
     * This field corresponds to the database column `device_gps_infos_count`.over_speed_alarm
     */
    @ColumnDescription(desc = PROPERTY_REMARK_OVERSPEEDALARM)
    private Integer overSpeedAlarm;

    /**
     * This method returns the value of the database column `device_gps_infos_count`.id
     *
     * @return the value of `device_gps_infos_count`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.id
     *
     * @param id the value for `device_gps_infos_count`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.device_id
     *
     * @return the value of `device_gps_infos_count`.device_id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.device_id
     *
     * @param deviceId the value for `device_gps_infos_count`.device_id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.count_date
     *
     * @return the value of `device_gps_infos_count`.count_date
     */
    public Date getCountDate() {
        return countDate;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.count_date
     *
     * @param countDate the value for `device_gps_infos_count`.count_date
     */
    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.drive_time
     *
     * @return the value of `device_gps_infos_count`.drive_time
     */
    public Double getDriveTime() {
        return driveTime;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.drive_time
     *
     * @param driveTime the value for `device_gps_infos_count`.drive_time
     */
    public void setDriveTime(Double driveTime) {
        this.driveTime = driveTime;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.car_front_collide
     *
     * @return the value of `device_gps_infos_count`.car_front_collide
     */
    public Integer getCarFrontCollide() {
        return carFrontCollide;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.car_front_collide
     *
     * @param carFrontCollide the value for `device_gps_infos_count`.car_front_collide
     */
    public void setCarFrontCollide(Integer carFrontCollide) {
        this.carFrontCollide = carFrontCollide;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.limit_speed_alarm
     *
     * @return the value of `device_gps_infos_count`.limit_speed_alarm
     */
    public Integer getLimitSpeedAlarm() {
        return limitSpeedAlarm;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.limit_speed_alarm
     *
     * @param limitSpeedAlarm the value for `device_gps_infos_count`.limit_speed_alarm
     */
    public void setLimitSpeedAlarm(Integer limitSpeedAlarm) {
        this.limitSpeedAlarm = limitSpeedAlarm;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.left_lane_deviate
     *
     * @return the value of `device_gps_infos_count`.left_lane_deviate
     */
    public Integer getLeftLaneDeviate() {
        return leftLaneDeviate;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.left_lane_deviate
     *
     * @param leftLaneDeviate the value for `device_gps_infos_count`.left_lane_deviate
     */
    public void setLeftLaneDeviate(Integer leftLaneDeviate) {
        this.leftLaneDeviate = leftLaneDeviate;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.city_front_collide
     *
     * @return the value of `device_gps_infos_count`.city_front_collide
     */
    public Integer getCityFrontCollide() {
        return cityFrontCollide;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.city_front_collide
     *
     * @param cityFrontCollide the value for `device_gps_infos_count`.city_front_collide
     */
    public void setCityFrontCollide(Integer cityFrontCollide) {
        this.cityFrontCollide = cityFrontCollide;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.car_distance_monitor
     *
     * @return the value of `device_gps_infos_count`.car_distance_monitor
     */
    public Integer getCarDistanceMonitor() {
        return carDistanceMonitor;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.car_distance_monitor
     *
     * @param carDistanceMonitor the value for `device_gps_infos_count`.car_distance_monitor
     */
    public void setCarDistanceMonitor(Integer carDistanceMonitor) {
        this.carDistanceMonitor = carDistanceMonitor;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.right_lane_deviate
     *
     * @return the value of `device_gps_infos_count`.right_lane_deviate
     */
    public Integer getRightLaneDeviate() {
        return rightLaneDeviate;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.right_lane_deviate
     *
     * @param rightLaneDeviate the value for `device_gps_infos_count`.right_lane_deviate
     */
    public void setRightLaneDeviate(Integer rightLaneDeviate) {
        this.rightLaneDeviate = rightLaneDeviate;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.car_start
     *
     * @return the value of `device_gps_infos_count`.car_start
     */
    public Integer getCarStart() {
        return carStart;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.car_start
     *
     * @param carStart the value for `device_gps_infos_count`.car_start
     */
    public void setCarStart(Integer carStart) {
        this.carStart = carStart;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.car_end
     *
     * @return the value of `device_gps_infos_count`.car_end
     */
    public Integer getCarEnd() {
        return carEnd;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.car_end
     *
     * @param carEnd the value for `device_gps_infos_count`.car_end
     */
    public void setCarEnd(Integer carEnd) {
        this.carEnd = carEnd;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.location_message
     *
     * @return the value of `device_gps_infos_count`.location_message
     */
    public Integer getLocationMessage() {
        return locationMessage;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.location_message
     *
     * @param locationMessage the value for `device_gps_infos_count`.location_message
     */
    public void setLocationMessage(Integer locationMessage) {
        this.locationMessage = locationMessage;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.speed_up
     *
     * @return the value of `device_gps_infos_count`.speed_up
     */
    public Integer getSpeedUp() {
        return speedUp;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.speed_up
     *
     * @param speedUp the value for `device_gps_infos_count`.speed_up
     */
    public void setSpeedUp(Integer speedUp) {
        this.speedUp = speedUp;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.speed_down
     *
     * @return the value of `device_gps_infos_count`.speed_down
     */
    public Integer getSpeedDown() {
        return speedDown;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.speed_down
     *
     * @param speedDown the value for `device_gps_infos_count`.speed_down
     */
    public void setSpeedDown(Integer speedDown) {
        this.speedDown = speedDown;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.vd_no_start
     *
     * @return the value of `device_gps_infos_count`.vd_no_start
     */
    public Integer getVdNoStart() {
        return vdNoStart;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.vd_no_start
     *
     * @param vdNoStart the value for `device_gps_infos_count`.vd_no_start
     */
    public void setVdNoStart(Integer vdNoStart) {
        this.vdNoStart = vdNoStart;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.device_active
     *
     * @return the value of `device_gps_infos_count`.device_active
     */
    public Integer getDeviceActive() {
        return deviceActive;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.device_active
     *
     * @param deviceActive the value for `device_gps_infos_count`.device_active
     */
    public void setDeviceActive(Integer deviceActive) {
        this.deviceActive = deviceActive;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.person_front_collide
     *
     * @return the value of `device_gps_infos_count`.person_front_collide
     */
    public Integer getPersonFrontCollide() {
        return personFrontCollide;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.person_front_collide
     *
     * @param personFrontCollide the value for `device_gps_infos_count`.person_front_collide
     */
    public void setPersonFrontCollide(Integer personFrontCollide) {
        this.personFrontCollide = personFrontCollide;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.collide_follow
     *
     * @return the value of `device_gps_infos_count`.collide_follow
     */
    public Integer getCollideFollow() {
        return collideFollow;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.collide_follow
     *
     * @param collideFollow the value for `device_gps_infos_count`.collide_follow
     */
    public void setCollideFollow(Integer collideFollow) {
        this.collideFollow = collideFollow;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.device_set_success
     *
     * @return the value of `device_gps_infos_count`.device_set_success
     */
    public Integer getDeviceSetSuccess() {
        return deviceSetSuccess;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.device_set_success
     *
     * @param deviceSetSuccess the value for `device_gps_infos_count`.device_set_success
     */
    public void setDeviceSetSuccess(Integer deviceSetSuccess) {
        this.deviceSetSuccess = deviceSetSuccess;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.device_set_fail
     *
     * @return the value of `device_gps_infos_count`.device_set_fail
     */
    public Integer getDeviceSetFail() {
        return deviceSetFail;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.device_set_fail
     *
     * @param deviceSetFail the value for `device_gps_infos_count`.device_set_fail
     */
    public void setDeviceSetFail(Integer deviceSetFail) {
        this.deviceSetFail = deviceSetFail;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.scores
     *
     * @return the value of `device_gps_infos_count`.scores
     */
    public Double getScores() {
        return scores;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.scores
     *
     * @param scores the value for `device_gps_infos_count`.scores
     */
    public void setScores(Double scores) {
        this.scores = scores;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.sum
     *
     * @return the value of `device_gps_infos_count`.sum
     */
    public Double getSum() {
        return sum;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.sum
     *
     * @param sum the value for `device_gps_infos_count`.sum
     */
    public void setSum(Double sum) {
        this.sum = sum;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.car_collide_follow
     *
     * @return the value of `device_gps_infos_count`.car_collide_follow
     */
    public Integer getCarCollideFollow() {
        return carCollideFollow;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.car_collide_follow
     *
     * @param carCollideFollow the value for `device_gps_infos_count`.car_collide_follow
     */
    public void setCarCollideFollow(Integer carCollideFollow) {
        this.carCollideFollow = carCollideFollow;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.person_collide_follow
     *
     * @return the value of `device_gps_infos_count`.person_collide_follow
     */
    public Integer getPersonCollideFollow() {
        return personCollideFollow;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.person_collide_follow
     *
     * @param personCollideFollow the value for `device_gps_infos_count`.person_collide_follow
     */
    public void setPersonCollideFollow(Integer personCollideFollow) {
        this.personCollideFollow = personCollideFollow;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.one_car_front_collide
     *
     * @return the value of `device_gps_infos_count`.one_car_front_collide
     */
    public Integer getOneCarFrontCollide() {
        return oneCarFrontCollide;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.one_car_front_collide
     *
     * @param oneCarFrontCollide the value for `device_gps_infos_count`.one_car_front_collide
     */
    public void setOneCarFrontCollide(Integer oneCarFrontCollide) {
        this.oneCarFrontCollide = oneCarFrontCollide;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.two_car_front_collide
     *
     * @return the value of `device_gps_infos_count`.two_car_front_collide
     */
    public Integer getTwoCarFrontCollide() {
        return twoCarFrontCollide;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.two_car_front_collide
     *
     * @param twoCarFrontCollide the value for `device_gps_infos_count`.two_car_front_collide
     */
    public void setTwoCarFrontCollide(Integer twoCarFrontCollide) {
        this.twoCarFrontCollide = twoCarFrontCollide;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.over_speed_follow
     *
     * @return the value of `device_gps_infos_count`.over_speed_follow
     */
    public Integer getOverSpeedFollow() {
        return overSpeedFollow;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.over_speed_follow
     *
     * @param overSpeedFollow the value for `device_gps_infos_count`.over_speed_follow
     */
    public void setOverSpeedFollow(Integer overSpeedFollow) {
        this.overSpeedFollow = overSpeedFollow;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_count`.over_speed_alarm
     *
     * @return the value of `device_gps_infos_count`.over_speed_alarm
     */
    public Integer getOverSpeedAlarm() {
        return overSpeedAlarm;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_count`.over_speed_alarm
     *
     * @param overSpeedAlarm the value for `device_gps_infos_count`.over_speed_alarm
     */
    public void setOverSpeedAlarm(Integer overSpeedAlarm) {
        this.overSpeedAlarm = overSpeedAlarm;
    }
}