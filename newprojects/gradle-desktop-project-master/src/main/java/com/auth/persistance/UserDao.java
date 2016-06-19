package com.auth.persistance;

import com.auth.persistance.models.User;

import java.util.List;

/**
 *
 */
public interface UserDao {

    /**
     *
     * @param name
     * @return
     */
    User findByName(String name);
    User findById(int id);
    List<User> getAll();

    void save(User user);
    void remove(User user);
    void update(User user);
}