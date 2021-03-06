<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="<c:url value="/"/>js/page/driverTime/action.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>驾驶时间</title>
    </head>
    <body>
        <div id="search">
            <form id="queryForm">
                <b>设备编号：</b>
                <input id="deviceId" name="deviceId" type="text" class="easyui-textbox" data-options="required:true"/>
                <b>开始时间：</b>
                <input class="easyui-my97" type="text" data-options="required:true,skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-{%d-1}\'}'" id="startDate">
                <b>结束时间：</b>
                <input class="easyui-my97" type="text" data-options="required:true,skin:'whyGreen',minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-{%d-1}'" id="endDate">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
            </form>
        </div>
        <div id="driveTimeCount" class="commonDiv"></div>
    </body>
</html>
