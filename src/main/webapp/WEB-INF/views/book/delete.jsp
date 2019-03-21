<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${book.title}</title>
</head>
<body>
    <h2>Do you wantto delete book: ${book.title}</h2>
    <h1><p><a href="${pageContext.request.contextPath}/book/list">No</a></p>
        <p><a href="/book/delete/confirm/${book.id}">Yes, delete book.</a></p></h1>
</body>
</html>
