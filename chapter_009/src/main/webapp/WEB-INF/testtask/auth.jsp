<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
    <c:if test="${error !=''}">
        <div>
            <c:out value="${error}"/>
        </div>
    </c:if>
    <table border="1"><tr><th>Auth user</th></tr><tr><td>
        <form action="${pageContext.servletContext.contextPath}/auth" method="post">
            <div>Login: <input type='text' name='login'/></div>
            <div>Password: <input type='password' name='password'/></div>
            <input type='submit'>
        </form>
    </td></tr></table>
</body>
</html>
