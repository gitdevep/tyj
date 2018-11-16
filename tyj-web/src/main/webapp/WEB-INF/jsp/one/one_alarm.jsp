<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>单车预警</title>
    </head>
    <body>
        <div id="newSearch">
            <form id="queryForm">
                <b>图表类型:</b>
                <input class="easyui-combobox" id="type" name="type" data-options="required:true" style="width:100px;"/>
                <b>设备编号:</b>
                <input class="easyui-textbox" id="deviceId" name="deviceId" data-options="required:true" style="width:100px;"/>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doDownload()">下载</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="doAddTime()">添加时间段</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="doDelTime()">删除时间段</a>
                <div id="conditionDiv">
                </div>
            </form>
            <iframe scrolling="auto" frameborder="0" id="oneIframe"  src="" style="width:100%;height:100%;"></iframe>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/one/one_action.js"></script>