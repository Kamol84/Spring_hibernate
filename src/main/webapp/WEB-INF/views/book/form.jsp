<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Book</h2>
<a href="${pageContext.request.contextPath}/book/list">Back to list</a>

<form:form modelAttribute="book" method="post">
    <form:input path="title" placeholder="title"/>
    <form:input path="rating" placeholder="rating"/>
    <form:select path="authors" multiple="true">
        <form:options items="${authors}" itemLabel="fullName" itemValue="id"/>
    </form:select>
    <form:select path="publisher" items="${publishers}"
                 itemValue="id" itemLabel="name"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
