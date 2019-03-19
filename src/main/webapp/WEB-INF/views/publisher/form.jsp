<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kamol
  Date: 19.03.19
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
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
        <input type="submit">
    </form:form>

</body>
</html>
