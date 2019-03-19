<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Books</h2>
<a href="${pageContext.request.contextPath}/book/list">Back to list</a>

<form:form modelAttribute="book" method="post">
    <form:input path="title" placeholder="title"/>
    <form:input path="rating" placeholder="rating"/>
    <form:select path="autor" items="${autors}" multiple="true"
                 itemLabel="name" itemValue="id"/>
    <form:select path="publisher" items="${publishers}"
                 itemValue="id" itemLabel="name"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
