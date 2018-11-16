<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/frame/common_map.css">
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=lTz3Ctx4eC9QAXl7ZjoyzyWb"></script>
    <title>信息窗口</title>
</head>
<body>
<div id="allmap"></div>
</body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/mapicon.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/map/message_window.js"></script>