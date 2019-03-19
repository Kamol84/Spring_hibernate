<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author</title>
</head>
<body>

<h2>Author</h2>
<a href="${pageContext.request.contextPath}/author/list">Back to list</a>

<form:form modelAttribute="author" method="post">
    <form:input path="firstName" placeholder="Name"/>
    <form:input path="lastName" placeholder="Surname"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
