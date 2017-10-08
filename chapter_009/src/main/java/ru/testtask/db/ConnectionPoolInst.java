package ru.testtask.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nikolay on 03/10/17.
 */
public final class ConnectionPoolInst {
    /**
     * Connection pool.
     */
    private static BasicDataSource connectionPool = null;
    /**
     * Constructor.
     */
    private ConnectionPoolInst() {
    }
    /**
     * pool getter.
     * @return - pool.
     */
    public static BasicDataSource getPool() {
        if (connectionPool == null) {
            connectionPool = new BasicDataSource();
            Properties props = new Properties();
            try {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                try (InputStream is = classLoader.getResourceAsStream("testtask.properties")) {
                    props.load(is);
                }
                String url = props.getProperty("jdbc.url");
                String username = props.getProperty("jdbc.username");
                String password = props.getProperty("jdbc.password");
                connectionPool.setUsername(username);
                connectionPool.setPassword(password);
                connectionPool.setDriverClassName("org.postgresql.Driver");
                connectionPool.setUrl(url);
                connectionPool.setInitialSize(5);
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }

        return connectionPool;
    }
}
