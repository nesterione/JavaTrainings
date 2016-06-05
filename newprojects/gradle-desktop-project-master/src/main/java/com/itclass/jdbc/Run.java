package com.itclass.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 CREATE TABLE USERS(
 ID INT PRIMARY KEY auto_increment,
 NAME VARCHAR(100),
 PASSWORD VARCHAR(100));

 INSERT INTO USERS VALUES(1,'user1','123');
 INSERT INTO USERS VALUES(2,'user2','123');

 */
public class Run {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //org.h2.Driver

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager
                .getConnection("jdbc:h2:e:/firstdb","igor","123");

            try(Statement statement =  conn.createStatement()) {

                ResultSet result = statement.executeQuery("select * from users");


                while (result.next()) {

                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String password = result.getString("password");

                    System.out.println(String.format("%d %s %s", id, name, password));
                }
            }

        conn.close();
    }

}
