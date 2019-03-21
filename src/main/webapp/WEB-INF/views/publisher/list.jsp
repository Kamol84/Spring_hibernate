<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher</title>
</head>
<body>
    <h2>Publishers List</h2>
    <a href="${pageContext.request.contextPath}/publisher/form">Add new</a>

    <ul>
        <c:forEach items="${publishers}" var="publisher">
            <li>
                ${publisher.name}
                    <a href="${pageContext.request.contextPath}/publisher/edit/${publisher.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/publisher/delete/${publisher.id}">Delete</a>
            </li>
        </c:forEach>
    </ul>

</body>
</html>