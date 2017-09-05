package ru.crud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by nikolay on 30/08/17.
 */
public class ConnectionDB {

    /**
     * Logger for DB.
     */
    private Logger logger = LogManager.getLogger(this.getClass().getName());
    /**
     * Constructor with db creation.
     */
    public ConnectionDB() {
        createDB();
    }
    /**
     * Connection getter.
     * @return connection to db.
     */
    public Connection getConnection() {

        Properties props = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            try (InputStream is = classLoader.getResourceAsStream("db.properties")) {
                props.load(is);
            }
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * Create DB structure.
     */
    private void createDB() {
        String createDB = "create table if not exists users (name varchar(254), login varchar(254) primary key, email varchar(254), createDate bigint);";
        try (Connection connection = this.getConnection()) {
            PreparedStatement stat = connection.prepareStatement(createDB);
            stat.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
