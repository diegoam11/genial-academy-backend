package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.UserDTO;
import com.diegodev.backendgenialacademy.entities.UserEntity;
import com.diegodev.backendgenialacademy.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping("/findByUsername/{username}")
    public UserDTO findById(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
