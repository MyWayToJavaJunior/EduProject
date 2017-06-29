package ru.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by nik on 3/13/2017.
 */
public class Tracker {
    /**
     * Queuerys.
     */
    private Map<String, String> querys;
    /**
     * Connection.
     */
    private Connection connection = getConnection();
    /**
     * Constructor.
     */
    public Tracker() {
        querys = getQuery();
        createDB();
    }
    /**
     * Connection creator.
     * @return - new connection.
     */
    public Connection getConnection() {
        Properties props = new Properties();
        try {
            try (InputStream is = Files.newInputStream(Paths.get("database.properties"))) {
                props.load(is);
            }
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Close connection.
     */
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Query getter.
     * @return - map of querys.
     */
    public Map<String, String> getQuery() {
        Map<String, String> querys = new HashMap<>();
        Properties props = new Properties();
        try {
            try (InputStream is = Files.newInputStream(Paths.get("querys"))) {
                props.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String query = props.getProperty("createDB");
        querys.put("createDB", query);
        query = props.getProperty("addItem");
        querys.put("addItem", query);
        query = props.getProperty("findAll");
        querys.put("findAll", query);
        query = props.getProperty("deleteItem");
        querys.put("deleteItem", query);
        query = props.getProperty("updateItem");
        querys.put("updateItem", query);
        query = props.getProperty("findByName");
        querys.put("findByName", query);
        query = props.getProperty("findById");
        querys.put("findById", query);

        return querys;
    }
    /**
     * Create DB if not exists.
     */
    public void createDB() {
        String createDB = querys.get("createDB");
        try {
            PreparedStatement stat = this.connection.prepareStatement(createDB);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add item to array.
     * @param item - item to add.
     * @return added to array item.
     */
    public Item add(Item item) {
        try {
            PreparedStatement stat = this.connection.prepareStatement(querys.get("addItem"));
            stat.setString(1, item.getId());
            stat.setString(2, item.getName());
            stat.setString(3, item.getDesc());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Update item.
     * @param item - item to update.
     */
    public void update(Item item) {
        try {
            PreparedStatement stat = this.connection.prepareStatement(querys.get("updateItem"));
            stat.setString(1, item.getName());
            stat.setString(2, item.getDesc());
            stat.setString(3, item.getId());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete item from array.
     * @param item - item to delete.
     */
    void delete(Item item) {

        try {
            PreparedStatement stat = this.connection.prepareStatement(querys.get("deleteItem"));
            stat.setString(1, item.getId());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find all items in array.
     * @return array of all items.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        try {
            PreparedStatement stat = this.connection.prepareStatement(querys.get("findAll"));
            ResultSet resultSet = stat.executeQuery();
            while (resultSet.next()) {
                Item tmp = new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("comm_date"));
                tmp.setId(resultSet.getString("id"));
                result.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find all items in array by name.
     * @param key - key for search.
     * @return all items equals by name.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();

        try {
            PreparedStatement stat = this.connection.prepareStatement(querys.get("findByName"));
            stat.setString(1, key);
            ResultSet resultSet = stat.executeQuery();
            while (resultSet.next()) {
                Item tmp = new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("comm_date"));
                tmp.setId(resultSet.getString("id"));
                result.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find all items in array by id.
     * @param id - id for search.
     * @return item equals by id.
     */
    public Item findById(String id) {
        Item result = null;

        try {
            PreparedStatement stat = this.connection.prepareStatement(querys.get("findById"));
            stat.setString(1, id);
            ResultSet resultSet = stat.executeQuery();
            while (resultSet.next()) {
                result = new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("comm_date"));
                result.setId(resultSet.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
