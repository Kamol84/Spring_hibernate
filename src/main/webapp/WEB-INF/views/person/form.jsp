<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>

    <form:form modelAttribute="person" method="post">
        <form:input path="login" placeholder="login"/>
        <form:password path="password" placeholder="password"/>
        <form:input path="email" placeholder="email"/>
        <input type="submit">

    </form:form>

</body>
</html>
