<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    </br><table border="1"><tr><th>Edit user <c:out value="${login}"></c:out></th></tr><tr><td>
    <form action='${pageContext.servletContext.contextPath}/edit' method='post'>
        <input type='hidden' name='login' value='<c:out value="${login}"></c:out>'/>
        New name: <input type='text' name='name'/>
        New eMail: <input type='text' name='email'/>
        <input type='submit'>
    </form>
    </td></tr></table>
</body>
</html>
