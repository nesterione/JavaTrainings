package com.di;

import com.google.inject.Inject;

import java.sql.Connection;

public class UserDaoDb implements UserDao {

    private ConnectionManager connectionManager;

    @Inject
    public UserDaoDb(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    public User getByName(String name) {

        Connection connection = connectionManager.getConnection();
        //try(PreparedStatement statement = connection.prepareStatement("SQL")) {

        // find youre
        System.out.println("find user");
        //return

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return null;
    }

}
