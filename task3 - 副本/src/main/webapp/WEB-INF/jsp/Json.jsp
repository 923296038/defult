<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" value="${message}"/>
    <json:array name="students" var="Student" items="${students}">
        <json:object>
            <json:property name="name" value="${Student.name}"/>
            <json:property name="student_id" value="${Student.student_id}"/>
            <json:property name="qq" value="${Student.qq}"/>
            <json:property name="type" value="${Student.learn_type}"/>
            <json:property name="estimatedtime" value="${Student.entrance_time}"/>
            <json:property name="school" value="${Student.school}"/>
            <json:property name="manner" value="${Student.senior}"/>
            <json:property name="daily" value="${Student.daily_link}"/>
            <json:property name="wish" value="${Student.wish}"/>
            <json:property name="counselor" value="${Student.way}"/>
            <json:property name="create_at" value="${Student.create_time}"/>
            <json:property name="update_at" value="${Student.update_time}"/>
            <br>
        </json:object>
    </json:array>
</json:object>