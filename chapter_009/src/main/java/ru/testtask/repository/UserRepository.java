package ru.testtask.repository;

import ru.testtask.dao.UserDAO;
import ru.testtask.db.ConnectionDB;
import ru.testtask.model.Address;
import ru.testtask.model.Role;
import ru.testtask.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 08/10/17.
 */
public class UserRepository implements IUserRepository {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * user dao.
     */
    private UserDAO userDAO = new UserDAO();
    /**
     * Users list.
     */
    private List<User> users = new ArrayList<>();
    /**
     * Constructor.
     */
    public UserRepository() {
        connectionDb = new ConnectionDB();
    }

    @Override
    public List<User> query(ISpecification spec) {
        String sql = "select u.name, u.login, u.pass, u.user_role, u.user_address, r.description, a.city, a.street, a.num "
                + "from usr as u join role as r on u.user_role = r.role_name join address as a on u.user_address = a.id" + spec.toSqlClauses();

        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                users.add(new User(
                        result.getString("name"),
                        result.getString("login"),
                        result.getString("pass"),
                        new Role(result.getString("user_role"), result.getString("description")),
                        new Address(result.getInt("user_address"), result.getString("city"), result.getString("street"), result.getInt("num")),
                        userDAO.getMusicTypesFromUser(result.getString("login"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
