<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>月告警总量</title>
    </head>
    <body>
        <div id="search">
            <form id="queryForm">
                <b>设备编号：</b>
                <input class="easyui-textbox" type="text" id="deviceId" data-options="required:true,prompt:'多个设备号,以英文逗号分隔'" style="width:300px;"/>
                <b>日期：</b>
                <input class="easyui-my97" type="text" data-options="required:true,skin:'whyGreen',maxDate:'%y-%M}',dateFmt:'yyyyMM'" id="dt">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doDownload()">下载</a>
            </form>
        </div>
        <div id="alarm" class="commonDiv"></div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/alarm/total_alarm_action.js"></script>
