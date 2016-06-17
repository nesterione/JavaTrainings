package com.di;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Service {


//    public static void doSome() {
//        ConnectionManager connectionManager = new ConnectionManager();
//        UserDao userDao = new UserDao(connectionManager);
//        userDao.getByName("sdf");
//    }

    public static void doSomeGuice(Injector injector) {

        UserDao userDao = injector.getInstance(UserDao.class);
        userDao.getByName("sdf");
    }



    public static void main(String[] args) {


//        doSome();
//        doSome();

        Injector injector = Guice.createInjector(new BillingModule());
        doSomeGuice(injector);
        doSomeGuice(injector);


    }
}
