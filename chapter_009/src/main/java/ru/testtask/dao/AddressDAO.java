package ru.testtask.dao;

import ru.testtask.db.ConnectionDB;
import ru.testtask.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 03/10/17.
 */
public class AddressDAO implements IDAO<Address> {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * Constructor.
     */
    public AddressDAO() {
        this.connectionDb = new ConnectionDB();
    }

    @Override
    public void add(Address address) {
        String city = address.getCity();
        String street = address.getStreet();
        Integer num = address.getNumber();
        String sql = "INSERT INTO address (city, street, num) values (?, ?, ?);";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, city);
            stat.setString(2, street);
            stat.setInt(3, num);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from address";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                addresses.add(new Address(result.getInt("id"),
                        result.getString("city"),
                        result.getString("street"),
                        result.getInt("num")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Address getOne(Address ad) {
        Address address = null;
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from address where city = ? and street = ? and num = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, ad.getCity());
            statement.setString(2, ad.getStreet());
            statement.setInt(3, ad.getNumber());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                address = new Address(result.getInt("id"),
                        result.getString("city"),
                        result.getString("street"),
                        result.getInt("num")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    /**
     * Get elem by id.
     * @param id - id.
     * @return - elem.
     */
    public Address getOne(Integer id) {
        Address address = null;
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from address where id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                address = new Address(result.getInt("id"),
                        result.getString("city"),
                        result.getString("street"),
                        result.getInt("num")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void edit(Address address) {
        Integer id = address.getId();
        String city = address.getCity();
        String street = address.getStreet();
        Integer num = address.getNumber();
        String sql = "UPDATE address SET city = ?, street = ?, num = ? WHERE id = ?";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, city);
            stat.setString(2, street);
            stat.setInt(3, num);
            stat.setInt(4, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Address ad) {
        String sql = "DELETE FROM address WHERE city = ? and street = ? and num = ?";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, ad.getCity());
            stat.setString(2, ad.getStreet());
            stat.setInt(3, ad.getNumber());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
