<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/2
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--error接受错误信息--%>
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="Error">
        ${Error.defaultMessage}
    </c:forEach>
</c:if>
<a href="/AllStudent">返回所有学生</a>

<%--&lt;%&ndash;json接受&ndash;%&gt;--%>
<%--<json:object>--%>
<%--    <json:array name="students" var="Student" items="${errors}">--%>
<%--        <json:object value="">--%>

<%--        </json:object>--%>
<%--    </json:array>--%>
<%--</json:object>--%>
</body>
</html>
