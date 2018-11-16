<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户信息</title>
    </head>
    <body>
        <table id="list"></table>
        <div id="toolbar">
            <input class="easyui-textbox" type="text" id="name" data-options="prompt:'用户名'" size="30" />
            状态<input class="easyui-combobox" id="status" style="width:90px;"/>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
            <auth:auth test="user/add_user">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="doAdd();">新增</a>
            </auth:auth>
            <auth:auth test="user/edit_user">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="doEdit()">编辑</a>
            </auth:auth>
            <auth:auth test="user/remove_user">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="doRemove()">删除</a>
            </auth:auth>
        </div>
        <div id="a" class="easyui-window" title="新增用户" data-options="closed:true," style="top:120px;width:500px;height:320px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <form id="f" class="easyui-form">
                        <table cellpadding="5">
                            <tr>
                                <td>用户名:</td>
                                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td><input class="easyui-textbox" type="password" name="password" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>权限用户ID:</td>
                                <td><input class="easyui-textbox" type="text" name="authId" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>车辆:</td>
                                <td>
                                    <input class="easyui-searchbox" id="acar" name="cars" data-options="prompt:'选择车辆',searcher: doASearchCars">
                                </td>
                            </tr>
                            <tr>
                                <td>团队:</td>
                                <td>
                                    <input class="easyui-searchbox" id="ateam" name="teams" data-options="prompt:'选择团队',searcher: doASearchTeams">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#f'), '../user/add_user', $('#a'));" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#a'));clearForm($('#f'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="e" class="easyui-window" title="编辑用户" data-options="closed:true," style="top:120px;width:500px;height:320px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <form id="ef" class="easyui-form">
                        <table cellpadding="5">
                            <input type="hidden" id="eUserId" name="id"/>
                            <tr>
                                <td>用户名:</td>
                                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td><input class="easyui-textbox" type="password" name="password" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>权限用户ID:</td>
                                <td><input class="easyui-textbox" type="text" name="authId" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>车辆:</td>
                                <td>
                                    <input class="easyui-searchbox" id="ecars" name="cars" data-options="prompt:'选择车辆',searcher: doESearchCarsMember">
                                </td>
                            </tr>
                            <tr>
                                <td>团队:</td>
                                <td>
                                    <input class="easyui-searchbox" id="eteams" name="teams" data-options="prompt:'选择团队',searcher: doESearchTeamsMember">
                                </td>
                            </tr>
                            <tr>
                                <td>状态:</td>
                                <td><input class="easyui-combobox" id="estatus" type="text" name="status"/></td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#ef'), '../user/edit_user', $('#e'));" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#e'));clearForm($('#ef'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="ad" class="easyui-window" title="新增车辆" data-options="closed:true" style="top:50px;width:800px;height:420px;padding:1px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <div>
                        <table id="ad_no_choice_list"></table>
                    </div>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="aSubmitCars();" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#ad'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="ed" class="easyui-window" title="编辑车辆" data-options="closed:true" style="top:50px;width:800px;height:420px;padding:1px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <div style="padding:10px;">
                        <table id="ed_choice_list"></table>
                    </div>
                    <div style="padding:10px;">
                        <table id="ed_no_choice_list"></table>
                    </div>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="eSubmitCars();" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="eRemoveCars();" style="width:80px">移除</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#ed'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="adt" class="easyui-window" title="新增团队" data-options="closed:true" style="top:50px;width:800px;height:420px;padding:1px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <div>
                        <table id="ad_no_choice_team_list"></table>
                    </div>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="aSubmitTeams();" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#adt'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="edt" class="easyui-window" title="编辑团队" data-options="closed:true" style="top:50px;width:800px;height:420px;padding:1px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <div style="padding:10px;">
                        <table id="ed_choice_team_list"></table>
                    </div>
                    <div style="padding:10px;">
                        <table id="ed_no_choice_team_list"></table>
                    </div>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="eSubmitTeams();" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="eRemoveTeams();" style="width:80px">移除</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#edt'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/user/device_model.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/general/user_team.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/general/user_model.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/general/user_action.js"></script>
