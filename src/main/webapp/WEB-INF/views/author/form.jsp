<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form:input path="pesel" placeholder="PESEL"/>
    <form:input path="email" placeholder="eMail"/>
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
