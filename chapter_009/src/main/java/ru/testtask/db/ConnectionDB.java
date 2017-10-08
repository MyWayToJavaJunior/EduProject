package ru.testtask.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        connectionPool = ConnectionPoolInst.getPool();
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
        String createDB = "create table if not exists role (role_name text primary key, description text); "
                        + "create table if not exists music_type (type_name text primary key, description text); "
                        + "create table if not exists address (id serial primary key, city text not null, street text not null, num int not null, unique(city, street, num)); "
                        + "create table if not exists usr (name text not null, login text primary key, pass text not null "
                        + ", user_role text REFERENCES role(role_name) not null, user_address int REFERENCES address(id) UNIQUE not null); "
                        + "create table if not exists music_type_user (id serial primary key, id_type text REFERENCES music_type(type_name) not null, id_user text REFERENCES usr(login) not null);";

        /*

        insert into role (role_name, description) values ('User', '');
        insert into role (role_name, description) values ('Mandator', '');
        insert into role (role_name, description) values ('Admin', '');

        insert into music_type (type_name, description) values ('Rap', '');
        insert into music_type (type_name, description) values ('Pop', '');
        insert into music_type (type_name, description) values ('Rock', '');

        insert into address (city, street, num) values ('SPb', 'Lenina', 1);
        insert into address (city, street, num) values ('SPb', 'Lenina', 2);
        insert into address (city, street, num) values ('SPb', 'Lenina', 3);

        insert into usr ( name, login, pass, user_role, user_address) values ('Lila', 'user', 'user', 'User', 1);
        insert into usr ( name, login, pass, user_role, user_address) values ('Bender', 'admin', 'admin', 'Admin', 3);
        insert into usr ( name, login, pass, user_role, user_address) values ('Fry', 'mand', 'mand', 'Mandator', 2);

        insert into music_type_user (id_type, id_user) values ('Rap', 'user');
        insert into music_type_user (id_type, id_user) values ('Pop', 'user');
        insert into music_type_user (id_type, id_user) values ('Pop', 'admin');
        insert into music_type_user (id_type, id_user) values ('Rock', 'admin');

         */


        try (Connection connection = this.connectionPool.getConnection()) {
            PreparedStatement stat = connection.prepareStatement(createDB);
            stat.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

}
