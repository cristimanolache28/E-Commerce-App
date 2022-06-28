package com.lov2code.shop.controller;

import com.lov2code.shop.entity.Role;
import com.lov2code.shop.entity.User;
import com.lov2code.shop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    // we tell to Spring Framework to inject an instance of the UserService
    @Autowired
    UserServiceImpl userService;

    @GetMapping()
    public String getAllUsers(Model model) {
        Iterable<User> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        Iterable<Role> listRoles = userService.listRoles();

        User user = new User();
        user.setEnable(true);

        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);

        return "user_form";
    }

    @PostMapping("/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        System.out.println(user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/users";
    }


}
