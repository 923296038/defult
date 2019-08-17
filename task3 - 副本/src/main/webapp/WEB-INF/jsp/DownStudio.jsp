<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/15
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>确认页面</title>
</head>
<body>
确定要下架吗
<a href="/Studios/AllStudios">取消</a><br><br>
<form name="studioForm" action="/Studios/DownStudio/${studio.id}"
      method="post" >
    <input type="hidden" name="id" value="${studio.id}"/>
    <input type="submit" value="确定" />
</form>
</body>
</html>
