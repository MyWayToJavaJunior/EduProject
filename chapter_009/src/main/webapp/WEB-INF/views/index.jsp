<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User base</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>eMail</th>
        <th>Date</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>

    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><c:out value="${user.createDate}"></c:out></td>
        <td>
            <form action='${pageContext.servletContext.contextPath}/del' method='post'>
                <input type='hidden' name='login' value='<c:out value="${user.login}"></c:out>'/>
                <input type='submit' value='delete'>
            </form>
        </td>
        <td>
            <form action='${pageContext.servletContext.contextPath}/show' method='post'>
                <input type='hidden' name='login' value='${user.login}'>
                <input type='submit' value='edit'>
            </form>
        </td>
    </tr>
    </c:forEach>

    </table>

    </br><table border="1"><tr><th>Add user</th></tr><tr><td>
    <form action="${pageContext.servletContext.contextPath}/add" method="post">
        Name: <input type='text' name='name'/>
        Login: <input type='text' name='login'/>
        eMail: <input type='text' name='email'/>
        <input type='submit'>
    </form>
    </td></tr></table>
</body>
</html>
