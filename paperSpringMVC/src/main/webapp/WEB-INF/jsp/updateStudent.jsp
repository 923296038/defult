<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";%>
<html>
<head>
    <title>修改论文</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改论文</small>
                </h1>
            </div>
        </div>
    </div>
    <%--action指向方法url
    id是原数据的id,输入框中输入name
    点击提交后,submit,参数传入updateStudent方法
    --%>
    <form name="studentForm" action="<%=basePath%>/updateStudent"
          method="post" >
        <input type="hidden" name="id" value="${student.id}"/>
        name：<input type="text" name="name" value="${student.name}"/>
<%--        wish：<input type="text" name="paperNum" value="${student.wish}"/>--%>
<%--        school：<input type="text" name="paperDetail" value="${student.school}"/>--%>
        <input type="submit" value="提交" />
        <c:if test="${allErrors != null }">
            <c:forEach items="${allErrors }" var="error">
                <font color="red" >${ error.defaultMessage}</font>
            </c:forEach>
        </c:if>
    </form>
</div>
</body>