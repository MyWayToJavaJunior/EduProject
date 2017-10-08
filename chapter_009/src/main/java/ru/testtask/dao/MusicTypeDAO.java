package ru.testtask.dao;

import ru.testtask.db.ConnectionDB;
import ru.testtask.model.MusicType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 03/10/17.
 */
public class MusicTypeDAO implements IDAO<MusicType> {
    /**
     * connection to db.
     */
    private ConnectionDB connectionDb;
    /**
     * Constructor.
     */
    public MusicTypeDAO() {
        this.connectionDb = new ConnectionDB();
    }

    @Override
    public void add(MusicType type) {
        String typeName = type.getType();
        String desc = type.getDescription();
        String sql = "INSERT INTO music_type (type_name, description) values (?, ?);";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, typeName);
            stat.setString(2, desc);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MusicType> getAll() {
        List<MusicType> types = new ArrayList<>();
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from music_type";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                types.add(new MusicType(result.getString("type_name"),
                        result.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    @Override
    public MusicType getOne(MusicType name) {
        MusicType type = null;
        try (Connection con = connectionDb.getConnection()) {
            String sql = "select * from music_type where type_name = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name.getType());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                type = new MusicType(result.getString("type_name"),
                        result.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public void edit(MusicType type) {
        String t = type.getType();
        String d = type.getDescription();
        String sql = "UPDATE music_type SET description = ? WHERE type_name = ?";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, d);
            stat.setString(2, t);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(MusicType name) {
        String sql = "DELETE FROM music_type WHERE type_name = ?";
        try (Connection con = connectionDb.getConnection()) {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, name.getType());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
