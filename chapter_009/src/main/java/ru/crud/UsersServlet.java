package ru.crud;

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
 * Created by nikolay on 30/08/17.
 */
public class UsersServlet extends HttpServlet {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * constructor with db connection creation.
     */
    public UsersServlet() {
        connectionDb = new ConnectionDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        User user;

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
                writer.append(user.toString()).append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.flush();
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

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String sql = "DELETE FROM users WHERE login = ?";

        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, login);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
