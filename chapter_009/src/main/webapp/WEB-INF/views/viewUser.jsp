<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="myBlock">
<table class="tableInside" border="1">
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>eMail</th>
        <th>Role</th>
        <th>Date</th>
        <th>Edit</th>
    </tr>
        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.role}"></c:out></td>
            <td><c:out value="${user.createDate}"></c:out></td>
            <td>
                <form action='${pageContext.servletContext.contextPath}/edit' method='get'>
                    <input type='hidden' name='login' value='${user.login}'>
                    <input type='submit' value='edit'>
                </form>
            </td>
        </tr>

</table>

</br><form action='${pageContext.servletContext.contextPath}/logout' method='post'>
    <input type='submit' value='exit'>
</form>
</div>
</body>
</html>
