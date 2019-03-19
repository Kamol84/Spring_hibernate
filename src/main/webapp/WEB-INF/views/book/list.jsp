<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Publisher List</h2>
<a href="${pageContext.request.contextPath}/book/form">Add new</a>

<ul>
    <c:forEach items="${books}" var="book">
        <li>
                ${book.title} - <a href="${pageContext.request.contextPath}/book/edit/${book.id}">Edit</a>
                                <a href="${pageContext.request.contextPath}/book/delete/${book.id}">Delete</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
