<%@ page import="ru.crud.User" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="ru.crud.ConnectionDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User base</title>
</head>
<body>
<table border="1"> <tr><th>Login</th><th>Name</th><th>eMail</th><th>Date</th><th>Delete</th><th>Edit</th></tr>
    <%
        ConnectionDB connectionDb = new ConnectionDB();
        User user;
        StringBuilder sb = new StringBuilder("<table border=\"1\"> <tr><th>Login</th><th>Name</th><th>eMail</th><th>Date</th><th>Delete</th><th>Edit</th></tr>");
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from users";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user = new User(result.getString("name"),
                        result.getString("login"),
                        result.getString("email"),
                        new Date(result.getLong("createDate")
                        ));
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
        } catch (SQLException e) {
            e.printStackTrace();
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
