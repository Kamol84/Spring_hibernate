<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kamol
  Date: 19.03.19
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
    <h2>Add Student</h2>
        <form:form modelAttribute="student" method="post">
            <form:input path="firstName" placeholder="name"/>
            <form:input path="lastName" placeholder="surname"/>
            <form:input path="gender" placeholder="gender"/>
            <form:select path="country" items="${countries}"/>
            <form:input path="notes" placeholder="notes"/>
            <form:checkbox path="mailingList"/>
            <form:select path="programmingSkills" items="${skills}" multiple="true"/>
            <form:checkboxes path="hobbies" items="${hobbieList}"/>



            <input type="submit">
        </form:form>

</body>
</html>
