<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <%String login = request.getParameter("login");%>
    </br><table border="1"><tr><th>Edit user <%=login%> </th></tr><tr><td>
    <form action='<%=request.getContextPath()%>/edit' method='post'>
        Login: <input type='hidden' name='login' value='<%=login%>'/>
        New name: <input type='text' name='name'/>
        New eMail: <input type='text' name='email'/>
        <input type='submit'>
    </form>
    </td></tr></table>
</body>
</html>
