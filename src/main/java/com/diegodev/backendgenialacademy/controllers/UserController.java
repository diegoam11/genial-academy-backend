package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.responses.UserRes;
import com.diegodev.backendgenialacademy.dtos.responses.UserDetailRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;
import com.diegodev.backendgenialacademy.entities.UserDetailEntity;
import com.diegodev.backendgenialacademy.exceptions.AuthenticationException;
import com.diegodev.backendgenialacademy.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserRes createUser(@RequestBody UserReq userReq) {
        return userService.createUser(userReq);
    }

    @GetMapping("/findByUsername/{username}")
    public UserRes findById(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/detail/{userId}")
    public UserDetailEntity findByUserId(@PathVariable Long userId) {
        return null;
    }

    @PostMapping("/addDetail")
    public UserDetailEntity addDetail(@RequestBody UserDetailRes userDetailRes) {
        return null;
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
