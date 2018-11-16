package com.tyj.dao.demo.general.vo;

import cn.vansky.framework.core.vo.BaseVo;
import com.tyj.dao.demo.general.bo.BaseData;

import java.util.Date;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/7/2
 */
public class BaseDataPageVo extends BaseVo<BaseData> {
    private int type;
    private Integer deviceId;
    private Double oil;
    private String startDate;
    private String endDate;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Double getOil() {
        return oil;
    }

    public void setOil(Double oil) {
        this.oil = oil;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
