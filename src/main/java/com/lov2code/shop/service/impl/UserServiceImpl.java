package com.lov2code.shop.service.impl;

import com.lov2code.shop.entity.Role;
import com.lov2code.shop.entity.User;
import com.lov2code.shop.repository.RoleRepository;
import com.lov2code.shop.repository.UserRepository;
import com.lov2code.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<Role> listRoles() {
        return roleRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
