<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
    <h2>Add Student</h2>
        <form:form modelAttribute="student" method="post">
            <p><form:input path="firstName" placeholder="name"/></p>
            <p>   <form:input path="lastName" placeholder="surname"/></p>
            <p><form:input path="gender" placeholder="gender"/></p>
            <p><form:select path="country" items="${countries}"/></p>
            <p><form:input path="notes" placeholder="notes"/></p>
            <p><label>mailing list</label><form:checkbox path="mailingList" name="Mailing List"/></p>
            <p><form:select path="programmingSkills" items="${skills}" multiple="true"/></p>
            <p><form:checkboxes path="hobbies" items="${hobbieList}"/></p>



            <input type="submit">
        </form:form>

</body>
</html>
