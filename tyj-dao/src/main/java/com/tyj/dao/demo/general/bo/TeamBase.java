/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_team`
 */
public abstract class TeamBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_team`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_team`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `tb_team`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_team`.team_name
     */
    private static final String PROPERTY_TEAMNAME = "teamName";

    /**
     * This field corresponds to the database column `tb_team`.team_name
     */
    private static final String PROPERTY_REMARK_TEAMNAME = "用户名";

    /**
     * This field corresponds to the database column `tb_team`.team_name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_TEAMNAME)
    private String teamName;

    /**
     * This method returns the value of the database column `tb_team`.id
     *
     * @return the value of `tb_team`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_team`.id
     *
     * @param id the value for `tb_team`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_team`.team_name
     *
     * @return the value of `tb_team`.team_name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * This method sets the value of the database column `tb_team`.team_name
     *
     * @param teamName the value for `tb_team`.team_name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}