package com.di;

import com.google.inject.Singleton;

import java.sql.Connection;

@Singleton
public class ConnectionManager {

    public ConnectionManager() {
        System.out.println("constructor: CM");
    }

    public Connection getConnection() {
        System.out.println("get connections");
        return null;
    }

}
