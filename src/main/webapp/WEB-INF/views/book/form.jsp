<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>

<h2>Book</h2>
<a href="${pageContext.request.contextPath}/book/list">Back to list</a>

<form:form modelAttribute="book" method="post">
    <form:input path="title" placeholder="title"/>
    <form:errors path="title" element="div"/>
    <form:input path="rating" placeholder="rating"/>
    <form:errors path="rating" element="div"/>
    <form:select path="authors" multiple="true">
        <form:options items="${authors}" itemLabel="fullName" itemValue="id"/>
    </form:select>
    <form:errors path="authors" element="div"/>
    <form:select path="publisher" items="${publishers}"
                 itemValue="id" itemLabel="name"/>
    <form:errors path="publisher" element="div"/>
    <form:select path="category.id" items="${categories}"
                 itemLabel="name" itemValue="id"/>
    <form:errors path="category" element="div"/>
    <form:textarea path="description" placeholder="Description"/>
    <form:errors path="description" element="div"/>
    <input type="submit" value="Save">
</form:form>
<%--<c:if test="${not empty errors}">--%>
    <%--<ul>--%>
        <%--<c:forEach items="${errors}" var="error">--%>
            <%--<li>--%>
                <%--${error.propertyPath}: ${error.mess`e}--%>
            <%--</li>--%>
        <%--</c:forEach>--%>
    <%--</ul>--%>
<%--</c:if>--%>
</body>
</html>
