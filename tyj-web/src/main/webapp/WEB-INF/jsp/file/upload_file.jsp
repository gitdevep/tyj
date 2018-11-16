<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>加载数据</title>
    </head>
    <body>
        <form method="POST" enctype="multipart/form-data" action="upload">
            File to upload: <input type="file" name="file"><br />
            <input type="submit" value="Upload">
        </form>
        <form method="POST" enctype="multipart/form-data" action="uploadXls">
            File to upload: <input type="file" name="file"><br />
            <input type="submit" value="Upload">
        </form>
    </body>
</html>
