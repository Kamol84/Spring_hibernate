<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h2>Publisher List</h2>
    <a href="${pageContext.request.contextPath}/publisher/form">Add new</a>

    <ul>
        <c:forEach items="${publishers}" var="publisher">
            <li>
                ${publisher.name}
            </li>
        </c:forEach>
    </ul>

</body>
</html>