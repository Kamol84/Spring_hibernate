<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>details</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/person/list">Show all</a>
<a href="${pageContext.request.contextPath}/person/form">Add new</a>
    <h2>Person details</h2>
        <ul>
            <li>Login: ${person.login}</li>
            <li>eMail: ${person.email}</li>
            <li><a href="${pageContext.request.contextPath}/person/edit/${person.id}">Edit</a></li>



        </ul>

</body>
</html>
