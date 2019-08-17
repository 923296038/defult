<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/14
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认删除</title>
</head>
<body>
<H1>
    确认要删除吗
</H1>
<td><form action="/Messages/LesserMessages/${message.id}" method="post">
    <%--         <td><form action="${pageContext.request.contextPath}/deleteStudent/{id}" method="post">--%>
    <input type="hidden" name="_method" value="DELETE">
    <input TYPE="submit" value="确定"></form>

    <a href="/Messages/AllMessages">取消</a>
</td>
</body>
</html>
