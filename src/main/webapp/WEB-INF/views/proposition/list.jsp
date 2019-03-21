<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proposition</title>
</head>
<body>
<h2>Proposition List</h2>
<a href="${pageContext.request.contextPath}/proposition/form">Add new</a>

<ul>
    <c:forEach items="${books}" var="book">
        <li>
                ${book.title} - <a href="${pageContext.request.contextPath}/proposition/edit/${book.id}">Edit</a>
            <a href="/proposition/delete/${book.id}">Delete</a>
            <a href="${pageContext.request.contextPath}/book/edit/${book.id}">Move to regular book</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
