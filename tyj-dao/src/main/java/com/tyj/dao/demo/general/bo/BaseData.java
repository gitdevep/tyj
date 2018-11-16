/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.bo;

/**
 * This class corresponds to the database table `tb_base_data`
 */
public class BaseData extends BaseDataBase {
    private double oilAvg;

    public double getOilAvg() {
        return oilAvg;
    }

    public void setOilAvg(double oilAvg) {
        this.oilAvg = oilAvg;
    }
}