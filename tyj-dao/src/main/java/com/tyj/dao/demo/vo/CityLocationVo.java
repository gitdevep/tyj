/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

import java.util.List;

/**
 * 通过经度纬度，调用百度地图，返回城市信息
 * Author: CK
 * Date: 2016/3/1
 */
public class CityLocationVo {
    /**
     * 0:正常，1:服务器内部错误，2:请求参数非法，3:权限校验失败，4:配额校验失败，5:ak不存在或者非法，
     * 101:服务禁用，102:不通过白名单或者安全码不对，2XX:无权限，3XX:配额错误
     */
    private Integer status;
    private Result result;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        /**
         * 坐标信息
         */
        private Location location;
        /**
         * 结构化地址信息
         */
        private String formatted_address;
        /**
         * 所在商圈信息，如 "人民大学,中关村,苏州街"
         */
        private String business;
        /**
         * 地址信息
         */
        private AddressComponent addressComponent;
        /**
         * 周边poi数组
         */
        private List<Pois> pois;
        private List<PoiRegions> poiRegions;
        /**
         * 当前位置结合POI的语义化结果描述。
         */
        private String sematic_description;
        private Integer cityCode;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponent getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponent addressComponent) {
            this.addressComponent = addressComponent;
        }

        public List<Pois> getPois() {
            return pois;
        }

        public void setPois(List<Pois> pois) {
            this.pois = pois;
        }

        public List<PoiRegions> getPoiRegions() {
            return poiRegions;
        }

        public void setPoiRegions(List<PoiRegions> poiRegions) {
            this.poiRegions = poiRegions;
        }

        public String getSematic_description() {
            return sematic_description;
        }

        public void setSematic_description(String sematic_description) {
            this.sematic_description = sematic_description;
        }

        public Integer getCityCode() {
            return cityCode;
        }

        public void setCityCode(Integer cityCode) {
            this.cityCode = cityCode;
        }
    }

    public static class PoiRegions {

    }

    public static class AddressComponent {
        /**
         * 国家
         */
        private String country;
        /**
         * 省名
         */
        private String province;
        /**
         * 城市名
         */
        private String city;
        /**
         * 区县名
         */
        private String district;
        /**
         * 街道名
         */
        private String street;
        /**
         * 街道门牌号
         */
        private String street_number;
        /**
         * 行政区划代码
         */
        private String adcode;
        /**
         * 国家代码
         */
        private Integer country_code;
        /**
         * 和当前坐标点的方向，当有门牌号的时候返回数据
         */
        private String direction;
        /**
         * 和当前坐标点的距离，当有门牌号的时候返回数据
         */
        private String distance;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreet_number() {
            return street_number;
        }

        public void setStreet_number(String street_number) {
            this.street_number = street_number;
        }

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public Integer getCountry_code() {
            return country_code;
        }

        public void setCountry_code(Integer country_code) {
            this.country_code = country_code;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }

    public static class Pois {
        /**
         * 地址信息
         */
        private String addr;
        /**
         * 数据来源
         */
        private String cp;
        /**
         * 和当前坐标点的方向
         */
        private String direction;
        /**
         * 离坐标点距离
         */
        private String distance;
        /**
         * poi名称
         */
        private String name;
        /**
         * poi类型，如’ 办公大厦,商务大厦’
         */
        private String poiType;
        /**
         * poi坐标{x,y}
         */
        private Point point;
        private String tag;
        /**
         * 电话
         */
        private String tel;
        /**
         * poi唯一标识
         */
        private String uid;
        /**
         * 邮编
         */
        private String zip;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getCp() {
            return cp;
        }

        public void setCp(String cp) {
            this.cp = cp;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPoiType() {
            return poiType;
        }

        public void setPoiType(String poiType) {
            this.poiType = poiType;
        }

        public Point getPoint() {
            return point;
        }

        public void setPoint(Point point) {
            this.point = point;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }

    public static class Point {
        private Double x;
        private Double y;

        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }

        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }
    }

    public static class Location {
        /**
         * 纬度坐标
         */
        private Double lat;
        /**
         * 经度坐标
         */
        private Double lng;

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }
    }
}
