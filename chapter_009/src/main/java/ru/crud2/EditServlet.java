package ru.crud2;

import ru.crud.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nikolay on 11/09/17.
 */
public class EditServlet extends HttpServlet {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * constructor with db connection creation.
     */
    public EditServlet() {
        connectionDb = new ConnectionDB();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String sql = "UPDATE users SET name = ?, email = ? WHERE login = ?";

        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, email);
            stat.setString(3, login);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("show");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String login = req.getParameter("login");
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title</title>"
                + "</head>"
                + "<body>"
                + "</br><table border=\"1\"><tr><th>Edit user " + login + "</th></tr><tr><td>"
                + "<form action='" + req.getContextPath() + "/edit' method='post'>"
                + "Login: <input type='hidden' name='login' value='" + login + "'/>"
                + "New name: <input type='text' name='name'/>"
                + "New eMail: <input type='text' name='email'/>"
                + "<input type='submit'>"
                + "</form>"
                + "</td></tr></table>"
                + "</body>"
                + "</html>");

        writer.flush();
    }
}
