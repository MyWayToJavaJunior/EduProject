<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/validate.js"></script>
    <script src="js/ajax.js"></script>
</head>
<body onload="foo()">
<div class="myBlock">
<table class="tableInside" border="1">
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>eMail</th>
        <th>Role</th>
        <th>Date</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>

    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><c:out value="${user.role}"></c:out></td>
        <td><c:out value="${user.createDate}"></c:out></td>
        <td>
            <form action='${pageContext.servletContext.contextPath}/del' method='post'>
                <input type='hidden' name='dellogin' value='<c:out value="${user.login}"></c:out>'/>
                <input type='submit' value='delete'>
            </form>
        </td>
        <td>
            <form action='${pageContext.servletContext.contextPath}/edit' method='get'>
                <input type='hidden' name='editlogin' value='${user.login}'>
                <input type='submit' value='edit'>
            </form>
        </td>
    </tr>
    </c:forEach>

    </table>
    </br><table class="tableInside" border="1"><tr><th>Add user</th></tr><tr><td>
    <form action="${pageContext.servletContext.contextPath}/add" method="post" id = "addNew" onsubmit="return validate()">
        <div class="formBlock"> Login: <input type='text' name='login'/> <span id="errorLogin" style="color: #ff2325; font-size: 12px"></span> </div>
        <div class="formBlock">Password: <input type='text' name='password'/> <span id="errorPass" style="color: #ff2325; font-size: 12px"></span> </div>
        <div class="formBlock">Name: <input type='text' name='name'/> <span id="errorName" style="color: #ff2325; font-size: 12px"></span> </div>
        <div class="formBlock">eMail: <input type='text' name='email'/> <span id="errorEmail" style="color: #ff2325; font-size: 12px"></span> </div>
        <div class="formBlock">Role: <select name="role">
            <option disabled>Choose role</option>
            <c:forEach items='${sessionScope.roles}' var="role">
            <option><c:out value="${role}"></c:out></option>
            </c:forEach>
        </select></div>

        <div class="formBlock">Country: <select name="country" id="country" onchange="return foo()">
            <option disabled>Choose country</option>
            <c:forEach items='${sessionScope.countrys}' var="country">
                <option><c:out value="${country}"></c:out></option>
            </c:forEach>
        </select></div>

        <div class="formBlock">City: <select name="city" id="city" >
            <option disabled>Choose city</option>
        </select></div>

        <input type='submit'>
    </form>
    </td></tr></table>

    </br><form action='${pageContext.servletContext.contextPath}/logout' method='post'>
        <input type='submit' value='exit'>
    </form>
</div>
</body>
</html>
