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

/**
 * Created by nikolay on 11/09/17.
 */
public class DelServlet extends HttpServlet {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * constructor with db connection creation.
     */
    public DelServlet() {
        connectionDb = new ConnectionDB();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String sql = "DELETE FROM users WHERE login = ?";

        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, login);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
