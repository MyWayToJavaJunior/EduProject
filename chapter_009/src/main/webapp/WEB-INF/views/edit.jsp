<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/validate.js"></script>
    <script src="js/ajax.js"></script>
</head>
<body onload="foo()">
<div class="myBlock">
    </br><table class="tableInside" border="1"><tr><th>Edit user <c:out value="${login}"></c:out></th></tr><tr><td>
    <form action='${pageContext.servletContext.contextPath}/edit' method='post' onsubmit="return validate()">
        <input type='hidden' name='login' value='<c:out value="${login}"></c:out>'/> <span id="errorLogin" style="color: #ff2325; font-size: 12px"></span>
        <div class="formBlock">New name: <input type='text' name='name'/> <span id="errorName" style="color: #ff2325; font-size: 12px"> </span></div>
        <div class="formBlock">New eMail: <input type='text' name='email'/> <span id="errorEmail" style="color: #ff2325; font-size: 12px"></span> </div>
        <div class="formBlock">New Password: <input type='text' name='password'/> <span id="errorPass" style="color: #ff2325; font-size: 12px"></span> </div>

        <c:if test='${sessionScope.role == "Admin"}'>
        <div class="formBlock">New role: <select name="roles">
                <option disabled>Choose role</option>
                <c:forEach items='${sessionScope.roles}' var="role">
                    <option><c:out value="${role}"></c:out></option>
                </c:forEach>
        </select></div>
        </c:if>

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
</div>
</body>
</html>
