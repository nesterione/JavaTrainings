package com.di;

public class UserDaoFake implements UserDao {


    @Override
    public User getByName(String name) {

        System.out.println("fake ");

        return new User();
    }
}
