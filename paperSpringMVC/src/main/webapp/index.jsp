<%--<%@ page ... %>	定义页面的依赖属性，比如脚本语言、error页面、缓存需求等等--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<% String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<html>
<head>
    <tittle><h1>首页</h1></tittle>
    <style type="text/css">
        a{
            text-decoration: antiquewhite;
            text-align: center;
            font-max-size: large;
        }
        h3{
            width: 180px;
            height:38px;
            margin: 100px auto;
            text-align: center;
        }
    </style>
</head>
<body>
<h3>
    <a href="<%=basePath%>/AllStudent">显示学生</a>
        <a href="<%=basePath%>/toStudentMore">添加学生</a>
    <a href="<%=basePath%>/json">测试json</a>
    <%--    <a href="<%=basePath%>/jump">学生管理界面</a>--%>
</h3>
</body>
</html>