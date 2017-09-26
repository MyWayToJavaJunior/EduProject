<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Auth</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="myBlock">
<c:if test="${error !=''}">
    <div>
        <c:out value="${error}"/>
    </div>
</c:if>
<table class="tableInside" border="1"><tr><th>Auth user</th></tr><tr><td>
    <form action="${pageContext.servletContext.contextPath}/auth" method="post">
        <div class="formBlock">Login: <input type='text' name='login'/></div>
        <div class="formBlock">Password: <input type='password' name='password'/></div>
        <input type='submit'>
    </form>
</td></tr></table>
</div>
</body>
</html>
