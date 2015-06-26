package com.service;

import com.entities.po.User;

import java.util.List;

/**
 * Created by u6031313 on 6/24/2015.
 * Content: UserService API
 */
public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    User findUserById(int id);

    void deleteUser(User user);

    List<User> findAllList();

    User findUserByNameAndPassword(User user);

    User loadUserById(int id);
}
