package com.auth;

import com.google.inject.AbstractModule;

import com.auth.persistance.UserDao;
import com.auth.persistance.UserDaoImpl;


public class BillingModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(UserDao.class).to(UserDaoImpl.class);
    }
}
