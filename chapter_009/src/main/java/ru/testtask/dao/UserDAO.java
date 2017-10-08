package ru.testtask.dao;

import ru.testtask.db.ConnectionDB;
import ru.testtask.model.Address;
import ru.testtask.model.MusicType;
import ru.testtask.model.Role;
import ru.testtask.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 03/10/17.
 */
public class UserDAO implements IDAO<User> {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * Address dao.
     */
    private AddressDAO addressDAO;
    /**
     * Constructor.
     */
    public UserDAO() {
        this.addressDAO = new AddressDAO();
        this.connectionDb = new ConnectionDB();
    }

    @Override
    public void add(User user) {
        String name = user.getName();
        String login = user.getLogin();
        String password = user.getPassword();
        Role role = user.getRole();
        Address addr = addressDAO.getOne(user.getAddress());

        if (addr == null) {
            addressDAO.add(new Address(user.getAddress().getCity(), user.getAddress().getStreet(), user.getAddress().getNumber()));
            addr = addressDAO.getOne(user.getAddress());
        }

        String sql = "INSERT INTO usr (name, login, pass, user_role, user_address) values (?, ?, ?, ?, ?);";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, login);
            stat.setString(3, password);
            stat.setString(4, role.getRole());
            stat.setInt(5, addr.getId());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        addMusicTypesToUser(login, user.getMusicTypes());
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try (Connection con = connectionDb.getConnection()) {
            String sql = "select u.name, u.login, u.pass, u.user_role, u.user_address, r.description, a.city, a.street, a.num "
                       + "from usr as u join role as r on u.user_role = r.role_name join address as a on u.user_address = a.id";

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                users.add(new User(
                        result.getString("name"),
                        result.getString("login"),
                        result.getString("pass"),
                        new Role(result.getString("user_role"), result.getString("description")),
                        new Address(result.getInt("user_address"), result.getString("city"), result.getString("street"), result.getInt("num")),
                        getMusicTypesFromUser(result.getString("login"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getOne(User u) {
        User user = null;
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select u.name, u.login, u.pass, u.user_address, r.role_name, r.description, a.city, a.street, a.num"
                    + " from usr as u join role as r on u.user_role = r.role_name join address as a on u.user_address = a.id where u.login = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, u.getLogin());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user = new User(
                        result.getString("name"),
                        result.getString("login"),
                        result.getString("pass"),
                        new Role(result.getString("role_name"), result.getString("description")),
                        new Address(result.getInt("user_address"), result.getString("city"), result.getString("street"), result.getInt("num")),
                        getMusicTypesFromUser(result.getString("login"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void edit(User user) {
        String name = user.getName();
        String login = user.getLogin();
        String password = user.getPassword();
        String roleName = user.getRole().getRole();

        addressDAO.edit(new Address(user.getAddress().getId(), user.getAddress().getCity(), user.getAddress().getStreet(), user.getAddress().getNumber()));

        String sql = "UPDATE usr SET name = ?, pass = ?, user_role = ?, user_address = ? WHERE login = ?";

        deleteAllMusicTypesFromUser(login);
        addMusicTypesToUser(login, user.getMusicTypes());

        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, password);
            stat.setString(3, roleName);
            stat.setInt(4, user.getAddress().getId());
            stat.setString(5, login);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(User u) {
        String sql = "DELETE FROM usr WHERE login = ?";
        deleteAllMusicTypesFromUser(u.getLogin());
        try (Connection con = connectionDb.getConnection()) {

            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, u.getLogin());
            stat.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        addressDAO.delete(u.getAddress());
    }

    /**
     * Check auth info.
     * @param login - login.
     * @param pass - password.
     * @return - result.
     */
    public boolean authCkeck(String login, String pass) {
        boolean result = false;

        List<User> users = this.getAll();

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(pass)) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * add music to user.
     * @param login - user.
     * @param types - music.
     */
    private void addMusicTypesToUser(String login, List<MusicType> types) {
        String sql = "INSERT INTO music_type_user (id_user, id_type) values (?, ?);";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, login);

            for (MusicType m : types) {
                stat.setString(2, m.getType());
                stat.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    /**
     * get user music.
     * @param login - user.
     * @return - list of music.
     */
    public List<MusicType> getMusicTypesFromUser(String login) {
        List<MusicType> types = new ArrayList<>();

        try (Connection con = connectionDb.getConnection()) {
            String sql = "select id_type from music_type_user where id_user = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                types.add(new MusicType(result.getString("id_type"), ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    /**
     * delete music from user.
     * @param login - user.
     */
    private void deleteAllMusicTypesFromUser(String login) {
        String sql = "DELETE FROM music_type_user WHERE id_user = ?;";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, login);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
