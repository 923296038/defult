<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/14
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>回复留言</title>
</head>
<body>

<td>${message.content}</td>
<br><br><br>

<form name="messageForm" action="/Messages/Response"
      method="post" >
    <input type="hidden" name="id" value="${message.id}"/>

    <input type="text" name="reply" value="${message.reply}"><br><br>

    <input type="submit" value="保存" />

</form>
</body>
</html>
