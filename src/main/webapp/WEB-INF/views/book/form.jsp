<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${not empty errors}">
    <ul>
        <c:forEach items="${errors}" var="error">
            <li>
                ${error.propertyPath}: ${error.message}
            </li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
