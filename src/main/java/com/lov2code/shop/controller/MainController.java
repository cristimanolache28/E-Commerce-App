package com.lov2code.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController public class MainController {

    @GetMapping("/home")
    public String viewHomePage() {
        return "index";
    }

}
