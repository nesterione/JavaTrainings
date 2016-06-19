package com.auth.persistance;

import com.google.inject.Inject;

import com.auth.persistance.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final ConnectionManager connectionManager;

    @Inject
    public UserDaoImpl(ConnectionManager connectionManager) {
        System.out.println("constructor: userdao");
        this.connectionManager = connectionManager;
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        Connection conn = connectionManager.getConnection();
        List<User> users = new ArrayList<>();

        // TODO
        try(Statement statement =  conn.createStatement()) {

            ResultSet result = statement.executeQuery("select * from users");

            while (result.next()) {

                int id = result.getInt("id");
                String name = result.getString("name");
                String password = result.getString("password");

                users.add(new User(id,name, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


    // TODO id generation
    @Override
    public void save(User user) {
        Connection conn = connectionManager.getConnection();
        try(PreparedStatement statement
                    = conn.prepareStatement(
                "INSERT INTO Users(name, password) VALUES(?,?)")) {

            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());

            // TODO
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }
}
