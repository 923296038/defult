<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/4/7
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>新增</title>
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
                    <small>新增论文</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        name： <input type="text" name="name"><br><br>
        qq:     <input type="text" name="qq"><br><br>
        专业:     <input type="text" name="learn_type"><br><br>
        入学时间:   <input type="text" name="entrance_time">时间戳<br><br>
        毕业学校:    <input type="text" name="school"><br><br>
        日报链接:    <input type="text" name="daily_link"><br><br>
        立愿:       <input type="text" name="wish"><br><br>
        师兄:      <input type="text" name="senior"><br><br>
        渠道:     <input type="text" name="way"><br><br>
<%--        创建时间: <input type="text" name="create_time">时间戳<br><br>--%>
<%--        修改时间:<input type="text" name="update_time">时间戳<br><br>--%>
        <input type="button" value="添加" onclick="addStudent()">
    </form>

    <script type="text/javascript">
        function addStudent() {
            var form = document.forms[0];
            form.action = "<%=basePath %>/StudentMore";
            form.method = "post";
            form.submit();
        }
    </script>
</div>