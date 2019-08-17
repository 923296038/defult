<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/15
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>新增工作室</title>
</head>
<body>
<form action="" name="studioForm" enctype="multipart/form-data">
    简介类型： <input type="text" name="studio_name"><br><br>
    图片:   <input title="file" name="picture"><br><br>
    正文:     <input type="text" name="body"><br><br>
    <%--        创建时间: <input type="text" name="create_time">时间戳<br><br>--%>
    <%--        修改时间:<input type="text" name="update_time">时间戳<br><br>--%>
    <input type="button" value="添加" onclick="addStudio()">
</form>

<script type="text/javascript">
    function addStudio() {
        var form = document.forms[0];
        form.action = "/Studios/MoreStudios";
        form.method = "post";
        form.submit();
    }
</script>
</body>
</html>
