package ru.testtask.dao;

import ru.testtask.db.ConnectionDB;
import ru.testtask.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 03/10/17.
 */
public class RoleDAO implements IDAO<Role> {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * Constructor.
     */
    public RoleDAO() {
        this.connectionDb = new ConnectionDB();
    }

    @Override
    public void add(Role role) {
        String roleName = role.getRole();
        String desc = role.getDescription();
        String sql = "INSERT INTO role (role_name, description) values (?, ?);";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, roleName);
            stat.setString(2, desc);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from role";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                roles.add(new Role(result.getString("role_name"),
                        result.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role getOne(Role name) {
        Role role = null;
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from role where role_name = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name.getRole());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                role = new Role(result.getString("role_name"),
                        result.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void edit(Role role) {
        String r = role.getRole();
        String d = role.getDescription();
        String sql = "UPDATE role SET description = ? WHERE role_name = ?";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, d);
            stat.setString(2, r);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Role name) {
        String sql = "DELETE FROM role WHERE role_name = ?";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name.getRole());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
