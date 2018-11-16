/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_weather`
 */
public abstract class WeatherBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_weather`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_weather`.id
     */
    private static final String PROPERTY_REMARK_ID = "主键ID";

    /**
     * This field corresponds to the database column `tb_weather`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_weather`.code
     */
    private static final String PROPERTY_CODE = "code";

    /**
     * This field corresponds to the database column `tb_weather`.code
     */
    private static final String PROPERTY_REMARK_CODE = "编码";

    /**
     * This field corresponds to the database column `tb_weather`.code
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CODE)
    private Byte code;

    /**
     * This field corresponds to the database column `tb_weather`.name_cn
     */
    private static final String PROPERTY_NAMECN = "nameCn";

    /**
     * This field corresponds to the database column `tb_weather`.name_cn
     */
    private static final String PROPERTY_REMARK_NAMECN = "中文名称";

    /**
     * This field corresponds to the database column `tb_weather`.name_cn
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NAMECN)
    private String nameCn;

    /**
     * This field corresponds to the database column `tb_weather`.name_en
     */
    private static final String PROPERTY_NAMEEN = "nameEn";

    /**
     * This field corresponds to the database column `tb_weather`.name_en
     */
    private static final String PROPERTY_REMARK_NAMEEN = "英文名称";

    /**
     * This field corresponds to the database column `tb_weather`.name_en
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NAMEEN)
    private String nameEn;

    /**
     * This method returns the value of the database column `tb_weather`.id
     *
     * @return the value of `tb_weather`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_weather`.id
     *
     * @param id the value for `tb_weather`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_weather`.code
     *
     * @return the value of `tb_weather`.code
     */
    public Byte getCode() {
        return code;
    }

    /**
     * This method sets the value of the database column `tb_weather`.code
     *
     * @param code the value for `tb_weather`.code
     */
    public void setCode(Byte code) {
        this.code = code;
    }

    /**
     * This method returns the value of the database column `tb_weather`.name_cn
     *
     * @return the value of `tb_weather`.name_cn
     */
    public String getNameCn() {
        return nameCn;
    }

    /**
     * This method sets the value of the database column `tb_weather`.name_cn
     *
     * @param nameCn the value for `tb_weather`.name_cn
     */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    /**
     * This method returns the value of the database column `tb_weather`.name_en
     *
     * @return the value of `tb_weather`.name_en
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * This method sets the value of the database column `tb_weather`.name_en
     *
     * @param nameEn the value for `tb_weather`.name_en
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}