<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/15
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑简介</title>
</head>
<body>
<form name="studentForm" action="/Studios/StudioINfo"
      method="post" >
    <input type="hidden" name="id" value="${studio.id}"/>
    简介类型：<input type="text" name="studio_name" value="${studio.studio_name}"/><br><br>
    正文：<input type="text" name="body" value="${studio.body}"/><br><br>

    <input type="submit" value="提交" />

</form>
</body>
</html>
