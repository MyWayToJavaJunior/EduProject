package ru.crud2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nikolay on 13/09/17.
 */
public class UserManager {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * constructor with db connection creation.
     */
    public UserManager() {
        connectionDb = new ConnectionDB();
    }
    /**
     * Get all users from DB.
     * @return - list of users.
     */
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from users";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                users.add(new User(result.getString("name"),
                        result.getString("login"),
                        result.getString("email"),
                        new Date(result.getLong("createDate")
                        )));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    /**
     * Add new user to DB.
     * @param user - new user.
     */
    public void add(User user) {
        String name = user.getName();
        String login = user.getLogin();
        String email = user.getEmail();
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
    /**
     * Edit user in DB.
     * @param user - user to edit.
     */
    public void edit(User user) {
        String name = user.getName();
        String login = user.getLogin();
        String email = user.getEmail();
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
    /**
     * Delete user from Db.
     * @param login - login to del.
     */
    public void delete(String login) {
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
