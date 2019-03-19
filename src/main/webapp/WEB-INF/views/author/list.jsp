<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Authors List</h2>
<a href="${pageContext.request.contextPath}/author/form">Add new</a>

<ul>
    <c:forEach items="${authors}" var="author">
        <li>
                ${author.fullName} - <a href="${pageContext.request.contextPath}/author/edit/${author.id}">Edit</a>
            <a href="${pageContext.request.contextPath}/author/delete/${author.id}">Delete</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
