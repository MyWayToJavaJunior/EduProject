package ru.crud2;

import ru.crud.ConnectionDB;
import ru.crud.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by nikolay on 05/09/17.
 */
public class ShowServlet extends HttpServlet {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * constructor with db connection creation.
     */
    public ShowServlet() {
        connectionDb = new ConnectionDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
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
                sb.append("<tr><td>" + user.getLogin() + "</td><td>" + user.getName() + "</td><td>" + user.getEmail() + "</td><td>" + user.getCreateDate() + "</td><td>"
                        + "<form action='" + req.getContextPath() + "/del' method='post'>"
                        + "<input type='hidden' name='login' value='" + user.getLogin() + "'/>"
                        + "<input type='submit' value='delete'></form>" + "</td><td>"
                        + "<form action='" + req.getContextPath() + "/edit' method='get'>"
                        + "<input type='hidden' name='login' value='" + user.getLogin() + "'/>"
                        + "<input type='submit' value='edit'></form>" + "</td></tr>");
            }
            sb.append("</table>");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title</title>"
                + "</head>"
                + "<body>"
                + sb.toString()
                + "</br><table border=\"1\"><tr><th>Add user</th></tr><tr><td>"
                + "<form action='" + req.getContextPath() + "/add' method='post'>"
                + "Name: <input type='text' name='name'/>"
                + "Login: <input type='text' name='login'/>"
                + "eMail: <input type='text' name='email'/>"
                + "<input type='submit'>"
                + "</form>"
                + "</td></tr></table>"
                + "</body>"
                + "</html>");

        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
