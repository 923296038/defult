<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/14
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.util.*" %>
<%@ page isELIgnored="false" %>
<% String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/tags" prefix="date"%>
<html>
<head>留言列表</title>
</head>
<body>
<form action="/Messages/MessageByName" method="GET">
    <label for="work_title">作品/标题名称：</label>
    <input id="work_title" name="work_title">
    <input type="submit" value="查询"/>
</form>
<table width="100%" border="1">
    <tbody>
    <tr>
        <th>序号</th>
        <th>作品标题</th>
        <th>留言游客昵称</th>
        <th>状态</th>
        <th>留言时间</th>
        <th>后台修改时间</th>
        <th>编辑人</th>
    </tr>
    <%--传入数据--%>
    <c:forEach items="${pageInfo.list}" var="message" >
        <tr>
            <td>${message.id}</td>
            <td>${message.work_title}</td>
            <td>${message.user_name}</td>
            <td>${message.status}</td>
            <td><date:date value ="${message.create_at} "/></td>
            <td><date:date value ="${message.update_at} "/></td>
            <td>${message.update_by}</td>
            <td><a href="<%=basePath%>/Messages/toMessageInfo/${message.id}">编辑</a></td>
            <td><a href="<%=basePath%>/Messages/toLesserMessages/${message.id}">去删除</a></td>
<%--            <td><form action="/Messages/toLesserMessages/${message.id}" method="post">--%>
<%--                <input type="hidden" name="_method" value="DELETE">--%>
<%--                <input TYPE="submit" value="删除"></form>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

    <p>当前 ${pageInfo.pageNum}页,总${pageInfo.pages}
        页,总 ${pageInfo.total} 条记录</div></p>
    <a href="/Messages/AllMessages?pageNo=${pageInfo.firstPage}">1</a>
    <c:if test="${pageInfo.hasNextPage}">
    <a href="/Messages/AllMessages?pageNo=${pageInfo.firstPage+1}">2</a>
    </c:if>
    <c:if test="${pageInfo.hasPreviousPage }">
    <a href="/Messages/AllMessages?pageNo=${pageInfo.pageNum-1}">上一页</a>
    </c:if>
    <c:if test="${pageInfo.hasNextPage }">
    <a href="/Messages/AllMessages?pageNo=${pageInfo.pageNum+1}">下一页</a>
    </c:if>
    <c:if test="${pageInfo.hasNextPage}">
    <a href="/Messages/AllMessages?pageNo=${pageInfo.lastPage}">${pageInfo.lastPage}</a>
    </c:if>
</body>
</html>
