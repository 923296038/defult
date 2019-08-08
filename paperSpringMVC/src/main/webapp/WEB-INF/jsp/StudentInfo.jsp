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
    <form name="studentForm" action="<%=basePath%>/StudentInfo"
          method="post" >
        <input type="hidden" name="id" value="${student.id}"/>
        name：<input type="text" name="name" value="${student.name}"/><br><br>
        学号：<input type="text" name="student_id" value="${student.student_id}"/><br><br>
        qq:     <input type="text" name="qq" value="${student.qq}"> <br><br>
        专业:     <input type="text" name="learn_type" value="${student.learn_type}"><br><br>
        入学时间:   <input type="text" name="entrance_time" value="${student.entrance_time}">请输入纯数字格式,如20190803<br><br>
        毕业学校:    <input type="text" name="school" value="${student.school}"><br><br>
        日报链接:    <input type="text" name="daily_link" value="${student.daily_link}"><br><br>
        立愿:       <input type="text" name="wish" value="${student.wish}"><br><br>
        师兄:      <input type="text" name="senior"value="${student.senior}"><br><br>
        渠道:     <input type="text" name="way"value="${student.way}"><br><br>
        <input type="submit" value="提交" />
        <c:if test="${allErrors != null }">
            <c:forEach items="${allErrors }" var="error">
                <font color="red" >${ error.defaultMessage}</font>
            </c:forEach>
        </c:if>
    </form>
</div>
</body>