package com.nacos.example.controller;

import com.nacos.example.model.User;
import com.nacos.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public User get(@RequestParam int id) {
        return userService.findById(id);
    }

}
