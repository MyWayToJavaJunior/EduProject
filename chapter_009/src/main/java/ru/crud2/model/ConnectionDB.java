package ru.crud2.model;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by nikolay on 30/08/17.
 */
public class ConnectionDB {
    /**
     * Connection pool.
     */
    private BasicDataSource connectionPool;
    /**
     * Logger for DB.
     */
    private Logger logger = LogManager.getLogger(this.getClass().getName());
    /**
     * Constructor with db creation.
     */
    public ConnectionDB() {
        connectionPool = new BasicDataSource();
        init();
        createDB();
    }
    /**
     * Connection getter.
     * @return connection to db.
     * @throws SQLException - ex.
     */
    public Connection getConnection() throws SQLException {
        return this.connectionPool.getConnection();
    }

    /**
     * Create DB structure.
     */
    private void createDB() {
        String createDB = "create table if not exists country (name text primary key);"
                + "create table if not exists city (name text primary key, countryname text REFERENCES country(name));"
                + "create table if not exists users (name varchar(254), login varchar(254) primary key, email varchar(254), createDate bigint, "
                + "password varchar(254), role varchar(128), country text REFERENCES country(name), countryname text REFERENCES country(name));";

//                + "insert into country (name) values ('Russia');"
//                + "insert into country (name) values ('Ukraine');"
//                + "insert into country (name) values ('Belarusia');"
//                + "insert into city (name, countryname) values ('Moscow', 'Russia');"
//                + "insert into city (name, countryname) values ('SPb', 'Russia');"
//                + "insert into city (name, countryname) values ('Novosibirsk', 'Russia');"
//                + "insert into city (name, countryname) values ('Kiev', 'Ukraine');"
//                + "insert into city (name, countryname) values ('Odessa', 'Ukraine');"
//                + "insert into city (name, countryname) values ('Harkov', 'Ukraine');"
//                + "insert into city (name, countryname) values ('Minsk', 'Belarusia');"
//                + "insert into city (name, countryname) values ('Bobruisk', 'Belarusia');";

        try (Connection connection = this.connectionPool.getConnection()) {
            PreparedStatement stat = connection.prepareStatement(createDB);
            stat.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
    /**
     * Pool initialization.
     */
    private void init() {
        Properties props = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            try (InputStream is = classLoader.getResourceAsStream("db.properties")) {
                props.load(is);
            }
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            this.connectionPool.setUsername(username);
            this.connectionPool.setPassword(password);
            this.connectionPool.setDriverClassName("org.postgresql.Driver");
            this.connectionPool.setUrl(url);
            this.connectionPool.setInitialSize(5);
        }  catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
