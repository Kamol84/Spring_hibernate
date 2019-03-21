<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proposition</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/proposition/list">Back to list</a>

<form:form modelAttribute="book" method="post">
    <form:input path="title" placeholder="title"/>
    <form:errors path="title" element="div"/>
    <form:input path="rating" placeholder="rating"/>
    <form:select path="authors" multiple="true">
        <form:options items="${authors}" itemLabel="fullName" itemValue="id"/>
    </form:select>
    <form:select path="publisher" items="${publishers}"
                 itemValue="id" itemLabel="name"/>
    <form:textarea path="description" placeholder="Description"/>
    <form:errors path="description" element="div"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
