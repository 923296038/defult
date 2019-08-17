<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/14
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>留言</title>
</head>
<body>

   <td>${message.content}</td><br><br><br><br>

   <a href="/Messages/AllMessages">取消</a><br><br>
   <form name="messageForm" action="/Messages/Selected/${message.id}"
         method="post" >
       <input type="hidden" name="id" value="${message.id}"/>
       <input type="submit" value="设为精选" />
   </form>

   <form name="messageForm" action="/Messages/unSelected/${message.id}"
             method="post" >
           <input type="hidden" name="id" value="${message.id}"/>
           <input type="submit" value="取消精选" /><br><br>
   <a href="/Messages/toResponse/${message.id}">回复</a>
   </form>
</body>
</html>
