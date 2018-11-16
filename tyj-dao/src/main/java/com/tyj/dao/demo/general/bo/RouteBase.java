/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_route`
 */
public abstract class RouteBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_route`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_route`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `tb_route`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_route`.route_name
     */
    private static final String PROPERTY_ROUTENAME = "routeName";

    /**
     * This field corresponds to the database column `tb_route`.route_name
     */
    private static final String PROPERTY_REMARK_ROUTENAME = "线路名";

    /**
     * This field corresponds to the database column `tb_route`.route_name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ROUTENAME)
    private String routeName;

    /**
     * This field corresponds to the database column `tb_route`.km
     */
    private static final String PROPERTY_KM = "km";

    /**
     * This field corresponds to the database column `tb_route`.km
     */
    private static final String PROPERTY_REMARK_KM = "公里数";

    /**
     * This field corresponds to the database column `tb_route`.km
     */
    @ColumnDescription(desc = PROPERTY_REMARK_KM)
    private Double km;

    /**
     * This field corresponds to the database column `tb_route`.oil_cost
     */
    private static final String PROPERTY_OILCOST = "oilCost";

    /**
     * This field corresponds to the database column `tb_route`.oil_cost
     */
    private static final String PROPERTY_REMARK_OILCOST = "油耗";

    /**
     * This field corresponds to the database column `tb_route`.oil_cost
     */
    @ColumnDescription(desc = PROPERTY_REMARK_OILCOST)
    private Double oilCost;

    /**
     * This field corresponds to the database column `tb_route`.start_lng
     */
    private static final String PROPERTY_STARTLNG = "startLng";

    /**
     * This field corresponds to the database column `tb_route`.start_lng
     */
    private static final String PROPERTY_REMARK_STARTLNG = "起点位置经度";

    /**
     * This field corresponds to the database column `tb_route`.start_lng
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STARTLNG)
    private Double startLng;

    /**
     * This field corresponds to the database column `tb_route`.start_lat
     */
    private static final String PROPERTY_STARTLAT = "startLat";

    /**
     * This field corresponds to the database column `tb_route`.start_lat
     */
    private static final String PROPERTY_REMARK_STARTLAT = "起点位置纬度";

    /**
     * This field corresponds to the database column `tb_route`.start_lat
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STARTLAT)
    private Double startLat;

    /**
     * This field corresponds to the database column `tb_route`.end_lng
     */
    private static final String PROPERTY_ENDLNG = "endLng";

    /**
     * This field corresponds to the database column `tb_route`.end_lng
     */
    private static final String PROPERTY_REMARK_ENDLNG = "终点位置经度";

    /**
     * This field corresponds to the database column `tb_route`.end_lng
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ENDLNG)
    private Double endLng;

    /**
     * This field corresponds to the database column `tb_route`.end_lat
     */
    private static final String PROPERTY_ENDLAT = "endLat";

    /**
     * This field corresponds to the database column `tb_route`.end_lat
     */
    private static final String PROPERTY_REMARK_ENDLAT = "终点位置纬度";

    /**
     * This field corresponds to the database column `tb_route`.end_lat
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ENDLAT)
    private Double endLat;

    /**
     * This field corresponds to the database column `tb_route`.start_name
     */
    private static final String PROPERTY_STARTNAME = "startName";

    /**
     * This field corresponds to the database column `tb_route`.start_name
     */
    private static final String PROPERTY_REMARK_STARTNAME = "起点名称";

    /**
     * This field corresponds to the database column `tb_route`.start_name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STARTNAME)
    private String startName;

    /**
     * This field corresponds to the database column `tb_route`.end_name
     */
    private static final String PROPERTY_ENDNAME = "endName";

    /**
     * This field corresponds to the database column `tb_route`.end_name
     */
    private static final String PROPERTY_REMARK_ENDNAME = "终点名称";

    /**
     * This field corresponds to the database column `tb_route`.end_name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ENDNAME)
    private String endName;

    /**
     * This method returns the value of the database column `tb_route`.id
     *
     * @return the value of `tb_route`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_route`.id
     *
     * @param id the value for `tb_route`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_route`.route_name
     *
     * @return the value of `tb_route`.route_name
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * This method sets the value of the database column `tb_route`.route_name
     *
     * @param routeName the value for `tb_route`.route_name
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    /**
     * This method returns the value of the database column `tb_route`.km
     *
     * @return the value of `tb_route`.km
     */
    public Double getKm() {
        return km;
    }

    /**
     * This method sets the value of the database column `tb_route`.km
     *
     * @param km the value for `tb_route`.km
     */
    public void setKm(Double km) {
        this.km = km;
    }

    /**
     * This method returns the value of the database column `tb_route`.oil_cost
     *
     * @return the value of `tb_route`.oil_cost
     */
    public Double getOilCost() {
        return oilCost;
    }

    /**
     * This method sets the value of the database column `tb_route`.oil_cost
     *
     * @param oilCost the value for `tb_route`.oil_cost
     */
    public void setOilCost(Double oilCost) {
        this.oilCost = oilCost;
    }

    /**
     * This method returns the value of the database column `tb_route`.start_lng
     *
     * @return the value of `tb_route`.start_lng
     */
    public Double getStartLng() {
        return startLng;
    }

    /**
     * This method sets the value of the database column `tb_route`.start_lng
     *
     * @param startLng the value for `tb_route`.start_lng
     */
    public void setStartLng(Double startLng) {
        this.startLng = startLng;
    }

    /**
     * This method returns the value of the database column `tb_route`.start_lat
     *
     * @return the value of `tb_route`.start_lat
     */
    public Double getStartLat() {
        return startLat;
    }

    /**
     * This method sets the value of the database column `tb_route`.start_lat
     *
     * @param startLat the value for `tb_route`.start_lat
     */
    public void setStartLat(Double startLat) {
        this.startLat = startLat;
    }

    /**
     * This method returns the value of the database column `tb_route`.end_lng
     *
     * @return the value of `tb_route`.end_lng
     */
    public Double getEndLng() {
        return endLng;
    }

    /**
     * This method sets the value of the database column `tb_route`.end_lng
     *
     * @param endLng the value for `tb_route`.end_lng
     */
    public void setEndLng(Double endLng) {
        this.endLng = endLng;
    }

    /**
     * This method returns the value of the database column `tb_route`.end_lat
     *
     * @return the value of `tb_route`.end_lat
     */
    public Double getEndLat() {
        return endLat;
    }

    /**
     * This method sets the value of the database column `tb_route`.end_lat
     *
     * @param endLat the value for `tb_route`.end_lat
     */
    public void setEndLat(Double endLat) {
        this.endLat = endLat;
    }

    /**
     * This method returns the value of the database column `tb_route`.start_name
     *
     * @return the value of `tb_route`.start_name
     */
    public String getStartName() {
        return startName;
    }

    /**
     * This method sets the value of the database column `tb_route`.start_name
     *
     * @param startName the value for `tb_route`.start_name
     */
    public void setStartName(String startName) {
        this.startName = startName;
    }

    /**
     * This method returns the value of the database column `tb_route`.end_name
     *
     * @return the value of `tb_route`.end_name
     */
    public String getEndName() {
        return endName;
    }

    /**
     * This method sets the value of the database column `tb_route`.end_name
     *
     * @param endName the value for `tb_route`.end_name
     */
    public void setEndName(String endName) {
        this.endName = endName;
    }
}