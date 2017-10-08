<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
Hi <c:out value="${user.getName()}"></c:out>!
Some information about you:
<table border="1">
    <tr>
        <td>Name</td>
        <td><c:out value="${user.getName()}"></c:out></td>
    </tr>
    <tr>
        <td>Login</td>
        <td><c:out value="${user.getLogin()}"></c:out></td>
    </tr>
    <tr>
        <td>Role</td>
        <td><c:out value="${user.getRole().getRole()}"></c:out></td>
    </tr>
    <tr>
        <td>Address</td>
        <td><c:out value="${user.getAddress().getCity()}"></c:out>,
            <c:out value="${user.getAddress().getStreet()}"></c:out>,
            <c:out value="${user.getAddress().getNumber()}"></c:out>
        </td>
    </tr>
    <tr>
        <td>Music types</td>
        <td>
            <c:forEach items='${user.getMusicTypes()}' var="type">
                <c:out value="${type.getType()}"></c:out>;
            </c:forEach>
        </td>
    </tr>
</table>

<hr>

<c:if test='${sessionScope.role == "Mandator" || sessionScope.role == "Admin"}'>
    All users:

    <table border="1">
        <tr>
            <th>Name</th>
            <th>Login</th>
            <th>Role</th>
            <th>Address</th>
            <th>Music types</th>

            <c:if test='${sessionScope.role == "Admin"}'>
                <th>Edit</th>
                <th>Delete</th>
            </c:if>
        </tr>

        <c:forEach items="${users}" var="u">
            <tr>
                <td><c:out value="${u.getName()}"></c:out></td>
                <td><c:out value="${u.getLogin()}"></c:out></td>
                <td><c:out value="${u.getRole().getRole()}"></c:out></td>
                <td>
                    <c:out value="${u.getAddress().getCity()}"></c:out>,
                    <c:out value="${u.getAddress().getStreet()}"></c:out>,
                    <c:out value="${u.getAddress().getNumber()}"></c:out>
                </td>
                <td>
                    <c:forEach items='${u.getMusicTypes()}' var="type">
                        <c:out value="${type.getType()}"></c:out>;
                    </c:forEach>
                </td>
                <c:if test='${sessionScope.role == "Admin"}'>
                    <td>
                        <form action='${pageContext.servletContext.contextPath}/del' method='post'>
                            <input type='hidden' name='delete_user' value='<c:out value="${u.getLogin()}"></c:out>'/>
                            <input type='submit' value='delete'>
                        </form>
                    </td>
                    <td>
                        <form action='${pageContext.servletContext.contextPath}/edit' method='get'>
                            <input type='hidden' name='edit_user' value='${u.getLogin()}'>
                            <input type='submit' value='edit'>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <hr>
</c:if>

<c:if test='${sessionScope.role == "Admin"}'>

    <table border="1"><tr><th>Add user</th></tr><tr><td>
        <form action="${pageContext.servletContext.contextPath}/add" method="post">
            Login: <input type='text' name='login'/><br>
            Password: <input type='text' name='password'/><br>
            Name: <input type='text' name='name'/><br>
            City: <input type='text' name='city'/><br>
            Street: <input type='text' name='street'/><br>
            Number: <input type='text' name='number'/><br>
            Role: <select name="role">
                <option disabled>Choose role</option>
                <c:forEach items='${sessionScope.roles}' var="role">
                    <option><c:out value="${role.getRole()}"></c:out></option>
                </c:forEach>
            </select>
            <br>
            <c:forEach items='${sessionScope.music}' var="m">
                <input type="checkbox" name="music_type" value="${m.getType()}">${m.getType()}
            </c:forEach>
            <br>
            <input type='submit'>
        </form>
    </td></tr></table>

</c:if>

<form action='${pageContext.servletContext.contextPath}/logout' method='post'>
    <input type='submit' value='Logout'>
</form>

</body>
</html>
