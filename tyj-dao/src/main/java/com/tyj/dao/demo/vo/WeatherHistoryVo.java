/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/3/1
 */
public class WeatherHistoryVo {
    /**
     * 当前城市
     */
    private String currentCity;
    /**
     * 错误码
     */
    private Integer error;
    /**
     * 返回结果状态信息
     */
    private String status;
    /**
     * 当前时间
     */
    private String date;
    /**
     * 天气预报信息
     */
    private List<Result> results;

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        /**
         * 当前城市
         */
        private String currentCity;
        /**
         * pm2.5
         */
        private String pm25;
        /**
         * 指数
         */
        private List<Index> index;
        /**
         *
         */
        private List<WeatherData> weather_data;

        public String getCurrentCity() {
            return currentCity;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public List<Index> getIndex() {
            return index;
        }

        public void setIndex(List<Index> index) {
            this.index = index;
        }

        public List<WeatherData> getWeather_data() {
            return weather_data;
        }

        public void setWeather_data(List<WeatherData> weather_data) {
            this.weather_data = weather_data;
        }
    }

    public static class Index {
        /**
         * 指数title
         */
        private String title;
        /**
         * 指数取值
         */
        private String zs;
        /**
         * 指数含义
         */
        private String tipt;
        /**
         * 指数详情
         */
        private String des;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getZs() {
            return zs;
        }

        public void setZs(String zs) {
            this.zs = zs;
        }

        public String getTipt() {
            return tipt;
        }

        public void setTipt(String tipt) {
            this.tipt = tipt;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }

    public static class WeatherData {
        /**
         * 天气预报时间
         */
        private String date;
        /**
         * 白天的天气预报图片url
         */
        private String dayPictureUrl;
        /**
         * 晚上的天气预报图片url
         */
        private String nightPictureUrl;
        /**
         * 天气状况
         */
        private String weather;
        /**
         * 风力
         */
        private String wind;
        /**
         * 温度
         */
        private String temperature;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDayPictureUrl() {
            return dayPictureUrl;
        }

        public void setDayPictureUrl(String dayPictureUrl) {
            this.dayPictureUrl = dayPictureUrl;
        }

        public String getNightPictureUrl() {
            return nightPictureUrl;
        }

        public void setNightPictureUrl(String nightPictureUrl) {
            this.nightPictureUrl = nightPictureUrl;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
    }
}
