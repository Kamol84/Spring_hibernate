<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Publisher</h2>
<a href="${pageContext.request.contextPath}/publisher/list">Back to list</a>

<form:form modelAttribute="publisher" method="post">
    <form:input path="name" placeholder="Name"/>
    <%--<form:input path="nip" placeholder="NIP"/>--%>
    <%--<form:input path="regon" placeholder="REGON"/>--%>

    <input type="submit">
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
