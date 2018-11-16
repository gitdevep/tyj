<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
        <%--<link rel="stylesheet" type="text/css" href="<%=basePath%>css/frame/common_map.css">--%>
        <%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=lTz3Ctx4eC9QAXl7ZjoyzyWb"></script>--%>
        <title>每百公里告警量统计</title>
    </head>
    <body>
        <div id="alarm" class="commonDiv"></div>
        <%--<div id="a" class="easyui-window" title="驾驶距离" data-options="closed:true," style="width:800px;height:400px;z-index:10">--%>
            <%--<div>--%>
                <%--<b>总里程：</b>--%>
                <%--<input class="easyui-textbox" type="text" id="kmSon" data-options="required:true"/>KM--%>
                <%--<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">确认</a>--%>
            <%--</div>--%>
            <%--<div id="allmap"></div>--%>
        <%--</div>--%>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/one/km_action.js"></script>
