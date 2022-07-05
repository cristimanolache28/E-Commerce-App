package com.lov2code.shop.service;

import com.lov2code.shop.entity.Role;
import com.lov2code.shop.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    Iterable<User> listUsers();

    Iterable<Role> listRoles();



}
