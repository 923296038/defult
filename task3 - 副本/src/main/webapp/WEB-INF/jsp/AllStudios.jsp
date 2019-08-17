<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/15
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.util.*" %>
<%@ page isELIgnored="false" %>
<% String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/tags" prefix="date"%>
<html>
<head>
    <title>工作室列表</title>
</head>
<body>
<h2><a href="/Studios/toMoreStudios">新增简介</a> </h2>
<table width="100%" border="1">
    <tbody>
    <tr>
        <th>序号</th>
        <th>名称</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>编辑人</th>
    </tr>
    <%--传入数据--%>
    <c:forEach items="${pageInfo.list}" var="studio" >
        <tr>
            <td>${studio.id}</td>
            <td>${studio.studio_name}</td>
            <td>${studio.status}</td>
            <td><date:date value ="${studio.create_at} "/></td>
            <td><date:date value ="${studio.update_at} "/></td>
            <td>${studio.update_by}</td>


            <c:if test="${studio.status != '上架'}">
            <td><a href="/Studios/toUp/${studio.id}">上架</a></td>
            </c:if>

            <c:if test="${studio.status == '上架'}">
            <td><a href="/Studios/toDown/${studio.id}">下架</a></td>
            </c:if>
            <td><a href="/Studios/toStudioInfo/${studio.id}">编辑</a></td>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>当前 ${pageInfo.pageNum}页,总${pageInfo.pages}
    页,总 ${pageInfo.total} 条记录</div></p>
<a href="/Studios/AllStudios?pageNo=${pageInfo.firstPage}">1</a>
<c:if test="${pageInfo.hasNextPage}">
    <a href="/Studios/AllStudios?pageNo=${pageInfo.firstPage+1}">2</a>
</c:if>
<c:if test="${pageInfo.hasPreviousPage }">
    <a href="/Studios/AllStudios?pageNo=${pageInfo.pageNum-1}">上一页</a>
</c:if>
<c:if test="${pageInfo.hasNextPage }">
    <a href="/Studios/AllStudios?pageNo=${pageInfo.pageNum+1}">下一页</a>
</c:if>
<c:if test="${pageInfo.hasNextPage}">
    <a href="/Studios/AllStudios?pageNo=${pageInfo.lastPage}">${pageInfo.lastPage}</a>
</c:if>
</body>
</html>
