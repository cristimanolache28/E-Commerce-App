package com.lov2ode.shop.service;

import com.lov2ode.shop.entity.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    void newUser(User user);

    User saveUser();

    User editUser(User user);

    void deleteUser(User user);
}
