/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_user_team`
 */
public abstract class UserTeamBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_user_team`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_user_team`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `tb_user_team`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_user_team`.team_id
     */
    private static final String PROPERTY_TEAMID = "teamId";

    /**
     * This field corresponds to the database column `tb_user_team`.team_id
     */
    private static final String PROPERTY_REMARK_TEAMID = "团队ID";

    /**
     * This field corresponds to the database column `tb_user_team`.team_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_TEAMID)
    private Integer teamId;

    /**
     * This field corresponds to the database column `tb_user_team`.user_id
     */
    private static final String PROPERTY_USERID = "userId";

    /**
     * This field corresponds to the database column `tb_user_team`.user_id
     */
    private static final String PROPERTY_REMARK_USERID = "用户ID";

    /**
     * This field corresponds to the database column `tb_user_team`.user_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_USERID)
    private Integer userId;

    /**
     * This method returns the value of the database column `tb_user_team`.id
     *
     * @return the value of `tb_user_team`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_user_team`.id
     *
     * @param id the value for `tb_user_team`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_user_team`.team_id
     *
     * @return the value of `tb_user_team`.team_id
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * This method sets the value of the database column `tb_user_team`.team_id
     *
     * @param teamId the value for `tb_user_team`.team_id
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     * This method returns the value of the database column `tb_user_team`.user_id
     *
     * @return the value of `tb_user_team`.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method sets the value of the database column `tb_user_team`.user_id
     *
     * @param userId the value for `tb_user_team`.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}