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
            <form id="queryForm">
                <b>类型：</b>
                <select class="easyui-combobox" id="type" data-options="panelHeight:'auto'" style="width:90px;">
                    <option value="1" selected>历史</option>
                    <option value="2">最新</option>
                </select>
                <b>设备编号：</b>
                <input class="easyui-textbox" id="deviceId" data-options="required:true" style="width:100px;"/>
                <b>油耗：</b>
                <input class="easyui-textbox" id="oil" data-options="required:true" style="width:90px;"/>
                <b>开始时间：</b>
                <input class="easyui-my97" data-options="required:true,skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}',dateFmt:'yyyy-MM-dd'" id="startDate">
                <b>结束时间：</b>
                <input class="easyui-my97" data-options="required:true,skin:'whyGreen',minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd'" id="endDate">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
            </form>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/general/base_model.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/general/base_action.js"></script>
