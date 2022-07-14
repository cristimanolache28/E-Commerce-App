package com.lov2code.shop.controller;

import com.lov2code.shop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// This is Spring RESTful webservice controller
@RestController
public class UserRestController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users/check_email")
    public String checkDuplicateEmail(@Param("email") String email) {
        return userService.isEmailUnique(email) ? "OK" : "Duplicated";
    }
}
