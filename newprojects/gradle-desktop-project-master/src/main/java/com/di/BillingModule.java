package com.di;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserDao.class).to(UserDaoFake.class);
    }

}
