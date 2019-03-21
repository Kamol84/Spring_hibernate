<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher</title>
</head>
<body>
<h2>Publisher</h2>
<a href="${pageContext.request.contextPath}/publisher/list">Back to list</a>

<form:form modelAttribute="publisher" method="post">
    <form:input path="name" placeholder="Name"/>
    <form:errors path="name"/>
    <form:input path="nip" placeholder="NIP"/>
    <form:errors path="nip"/>
    <form:input path="regon" placeholder="REGON"/>
    <form:errors path="regon"/>

    <input type="submit">
</form:form>


</body>
</html>
