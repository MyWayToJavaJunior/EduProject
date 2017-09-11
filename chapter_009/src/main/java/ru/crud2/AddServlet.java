package ru.crud2;

import ru.crud.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by nikolay on 05/09/17.
 */
public class AddServlet extends HttpServlet {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * constructor with db connection creation.
     */
    public AddServlet() {
        connectionDb = new ConnectionDB();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String sql = "INSERT INTO users (name, login, email, createDate) values (?, ?, ?, ?);";

        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, login);
            stat.setString(3, email);
            stat.setLong(4, new Date().getTime());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("show");
    }
}
