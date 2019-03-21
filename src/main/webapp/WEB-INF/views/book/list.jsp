<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Books List</h2>
<a href="${pageContext.request.contextPath}/book/form">Add new</a>
<hr/>
Categories:
<a href="${pageContext.request.contextPath}/book/list">All</a>

<c:forEach items="${categories}" var="category">
<a href="${pageContext.request.contextPath}/book/list?pro=false&catid=${category.id}">
    ${category.name}</a>
</c:forEach>

<form method="get">
    <input type="search" name="title" placeholder="Book title">
    <input type="submit" value="search">
</form>

<ul>
    <c:forEach items="${books}" var="book">
        <li>
            <h2>${book.title}</h2>- <a href="${pageContext.request.contextPath}/book/edit/${book.id}">Edit</a>
            <a href="${pageContext.request.contextPath}/book/delete/${book.id}">Delete</a>
            <publisher>publisher: ${book.publisher.name}</publisher>
            <publisher>category: ${book.category.name}</publisher>


        </li>
    </c:forEach>
</ul>
</body>
<head>
    <title>Book</title>
</head>
</html>
