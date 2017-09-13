<%@ page import="ru.crud2.model.User" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="ru.crud.ConnectionDB" %>
<%@ page import="ru.crud2.model.UserManager" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User base</title>
</head>
<body>
<table border="1"> <tr><th>Login</th><th>Name</th><th>eMail</th><th>Date</th><th>Delete</th><th>Edit</th></tr>
    <%
        UserManager userManager = new UserManager();
        List<User> users = userManager.getAll();


        StringBuilder sb = new StringBuilder("<table border=\"1\"> <tr><th>Login</th><th>Name</th><th>eMail</th><th>Date</th><th>Delete</th><th>Edit</th></tr>");

        for(User user : users) {
    %>

    <tr>
        <td><%=user.getLogin()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getCreateDate()%></td>
        <td>
            <form action='<%=request.getContextPath()%>/del' method='post'>
            <input type='hidden' name='login' value='<%=user.getLogin()%>'/>
            <input type='submit' value='delete'></form>
        </td>
        <td>
            <form action='<%=request.getContextPath()%>/edit.jsp' method='post'>
            <input type='hidden' name='login' value='<%=user.getLogin()%>'/>
                <input type='submit' value='edit'></form>
        </td>
    </tr>

    <%
        }
    %>
    </table>

    </br><table border="1"><tr><th>Add user</th></tr><tr><td>
    <form action="<%=request.getContextPath()%>/add" method="post">
        Name: <input type='text' name='name'/>
        Login: <input type='text' name='login'/>
        eMail: <input type='text' name='email'/>
        <input type='submit'>
    </form>
    </td></tr></table>
</body>
</html>
