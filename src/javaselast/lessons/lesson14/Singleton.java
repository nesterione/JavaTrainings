package javaselast.lessons.lesson14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

    public static void main(String[] args) {
        ConnectionSingleton.getInstance();
        ConnectionSingletonTwo.INSTANCE.getConnection();
    }
}

enum ConnectionSingletonTwo {
    INSTANCE;

    private Connection instance;

    {
        if(instance==null) {
            try {
                instance = DriverManager.getConnection("url","user","pass");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return instance;
    }

}

class ConnectionSingleton {

    private static Connection instance;

    public static Connection getInstance() {
        if(instance==null) {
            try {
                instance = DriverManager.getConnection("url","user","pass");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
























