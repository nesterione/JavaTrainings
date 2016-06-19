package com.auth;

import com.google.inject.Guice;
import com.google.inject.Injector;

import com.auth.persistance.DataSource;
import com.auth.persistance.UserDaoImpl;
import com.auth.persistance.ConnectionManager;
import com.auth.persistance.UserDao;
import com.auth.persistance.models.User;

public class Run {

    public static void main(String[] args) {

        // without google guice
        //DataSource dataSource = new DataSource();
        //ConnectionManager conn = new ConnectionManager(dataSource);
        //UserDao userDao = new UserDaoImpl(conn);
        //userDao.getAll().forEach(System.out::println);

        // with guice
        Injector injector = Guice.createInjector(new BillingModule());
        UserDao userDao = injector.getInstance(UserDao.class);
        userDao.save(new User(-1, "qwer","qwer"));

        userDao.getAll().forEach(System.out::println);
    }

}
