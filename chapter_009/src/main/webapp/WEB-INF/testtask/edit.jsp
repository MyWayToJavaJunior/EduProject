<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<table border="1"><tr><th>Edit user</th></tr><tr><td>
    <form action="${pageContext.servletContext.contextPath}/edit" method="post">
        <input type='hidden' name='address_id' value="${address_id}" />
        <input type='hidden' name='login_val' value="${ulogin}" />
        Login: <input type='text' name='login' value="${ulogin}" disabled/><br>
        Password: <input type='text' name='password' value="${password}"/><br>
        Name: <input type='text' name='name' value="${name}"/><br>
        City: <input type='text' name='city' value="${city}"/><br>
        Street: <input type='text' name='street' value="${street}"/><br>
        Number: <input type='text' name='number' value="${number}"/><br>
        Role: <select name="role">
        <option>${role}</option>
        <c:forEach items='${sessionScope.roles}' var='r'>
            <c:if test="${role != r.getRole()}">
                <option><c:out value='${r.getRole()}'></c:out></option>
            </c:if>
        </c:forEach>
    </select>
        <br>
        <c:forEach items='${sessionScope.music}' var="m">
            <c:if test="${music.contains(m)}">
                <input type="checkbox" name="music_type" value="${m.getType()}" checked>${m.getType()}
            </c:if>
            <c:if test="${!music.contains(m)}">
                <input type="checkbox" name="music_type" value="${m.getType()}">${m.getType()}
            </c:if>
        </c:forEach>
        <br>
        <input type='submit'>
    </form>
</td></tr></table>
</body>
</html>
