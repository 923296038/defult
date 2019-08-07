<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>forEach迭代</title>
</head>
<body>

<c:forEach begin="1" end="5" step="1" var="i">
    <h3>${i }、主体内容</h3>
</c:forEach>

<hr>
<%--step2 步长为2--%>
<c:forEach begin="1" end="10" step="2" var="i">
    <h3>${i }、主体内容</h3>
</c:forEach>

<hr>
<%
    List<String> list = new ArrayList<>();
    list.add("张三");
    list.add("李四");
    list.add("王五");
    request.setAttribute("list", list);
%>

<table border="1" style="border-collapse: collapse;">
    <tr>
        <th>姓名</th>
        <th>当前成员的下标</th>
        <th>循环的次数</th>
        <th>当前成员是否第一次被循环</th>
        <th>当前成员是否最后一次被循环</th>
    </tr>
    <c:forEach items="${list }" var="item" varStatus="info">
        <tr>
            <td>${item }</td>
            <td>${info.index }</td>
            <td>${info.count }</td>
            <td>${info.first }</td>
            <td>${info.last }</td>
        </tr>
    </c:forEach>
</table>

<hr>

<%
    Map<String,Object> map = new HashMap<>();
    map.put("zhangsan","张三，今年18，性别男爱好女");
    map.put("lisi","李四，今年18，爱好张三");
    map.put("wangeu","王五，今年20，爱好李四");
    map.put("admin",list);

    request.setAttribute("myMap", map);
%>

<c:forEach items="${myMap }" var="user">

    ${user.key } = ${user.value } <br>

</c:forEach>

</body>
</html>