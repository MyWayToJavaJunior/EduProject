package ru.crud2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
                        new Date(result.getLong("createDate")),
                        result.getString("password"),
                        Role.valueOf(result.getString("role"))
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * user from DB.
     * @param login - login.
     * @return - user.
     */
    public User getUser(String login) {
        User user = null;
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from users where login=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user = new User(result.getString("name"),
                        result.getString("login"),
                        result.getString("email"),
                        new Date(result.getLong("createDate")),
                        result.getString("password"),
                        Role.valueOf(result.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Add new user to DB.
     * @param user - new user.
     */
    public void add(User user) {
        String name = user.getName();
        String login = user.getLogin();
        String email = user.getEmail();
        String sql = "INSERT INTO users (name, login, email, createDate, password, role) values (?, ?, ?, ?, ?, ?);";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, login);
            stat.setString(3, email);
            stat.setLong(4, new Date().getTime());
            stat.setString(5, user.getPassword());
            stat.setString(6, user.getRole().name());
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
        String sql = "UPDATE users SET name = ?, email = ?, password = ?, role = ? WHERE login = ?";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, email);
            stat.setString(3, user.getPassword());
            stat.setString(4, user.getRole().name());
            stat.setString(5, login);
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
    /**
     * Chech login and password.
     * @param login - login.
     * @param password - password.
     * @return - correct or not.
     */
    public boolean isCredentional(String login, String password) {
        List<User> users = this.getAll();
        boolean exists = false;
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    /**
     * Get all roles.
     * @return - list of roles.
     */
    public List<Role> getAllRoles() {
        return new ArrayList<Role>(Arrays.asList(Role.values()));
    }
    /**
     * Get user role.
     * @param login - login.
     * @return - role.
     */
    public Role getRole(String login) {
        List<User> users = this.getAll();
        Role role = null;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                role = user.getRole();
                break;
            }
        }
        return role;
    }
}
