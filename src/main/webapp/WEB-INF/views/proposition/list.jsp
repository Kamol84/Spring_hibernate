<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proposition</title>
</head>
<body>
<h2>Proposition List</h2>
<a href="${pageContext.request.contextPath}/proposition/form">Add new</a>
<hr/>
Categories:
<a href="${pageContext.request.contextPath}/proposition/list">All</a>

<c:forEach items="${categories}" var="category">
    <a href="${pageContext.request.contextPath}/proposition/list?pro=true&catid=${category.id}">
            ${category.name}</a>
</c:forEach>


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
