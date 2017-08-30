package ru.parsersqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * Created by nikolay on 23/07/17.
 */
public class WorkWithDB {
    /**
     * Logger for DB.
     */
    private Logger logger = LogManager.getLogger(this.getClass().getName());
    /**
     * Constructor.
     */
    public WorkWithDB() {
        createDB();
    }
    /**
     * Get DB connection.
     * @return - connection.
     */
    private java.sql.Connection getConnection() {
        Properties props = new Properties();
        try {
            try (InputStream is = Files.newInputStream(Paths.get("ParserDB.properties"))) {
                props.load(is);
            }
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
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
        String createDB = "CREATE TABLE IF NOT EXISTS Ads (link VARCHAR(200), subject VARCHAR(200), ad_content TEXT, create_date BIGINT, CONSTRAINT pk PRIMARY KEY(link));";
        try (Connection connection = getConnection()) {
            PreparedStatement stat = connection.prepareStatement(createDB);
            stat.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
    /**
     * Add ad to DB.
     * @param subj - subject.
     * @param content - content.
     * @param date - date.
     * @param link - link.
     */
    public void add(String link, String subj, String content, long date) {
        String query = "INSERT INTO Ads (link, subject, ad_content, create_date) values (?, ?, ?, ?);";
        try (Connection connection = getConnection()) {
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setString(1, link);
            stat.setString(2, subj);
            stat.setString(3, content);
            stat.setLong(4, date);
            stat.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("already exists")) {
                logger.info("Duplicate found.");
            } else {
                logger.error(e.getMessage());
            }
        }
    }
}
