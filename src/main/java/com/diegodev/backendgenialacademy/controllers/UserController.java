package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.UserDTO;
import com.diegodev.backendgenialacademy.dtos.UserDetailDTO;
import com.diegodev.backendgenialacademy.entities.UserDetailEntity;
import com.diegodev.backendgenialacademy.entities.UserEntity;
import com.diegodev.backendgenialacademy.services.UserDetailService;
import com.diegodev.backendgenialacademy.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;
    UserDetailService userDetailService;

    public UserController(UserService userService, UserDetailService userDetailService) {
        this.userService = userService;
        this.userDetailService = userDetailService;
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping("/findByUsername/{username}")
    public UserDTO findById(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/detail/{userId}")
    public UserDetailEntity findByUserId(@PathVariable Long userId) {
        return userDetailService.findByUserId(userId);
    }

    @PostMapping("/addDetail")
    public UserDetailEntity addDetail(@RequestBody UserDetailDTO userDetailDTO) {
        return null;
    }
}
