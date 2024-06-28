package com.diegodev.backendgenialacademy.auth;

import com.diegodev.backendgenialacademy.dtos.responses.AuthRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserLoginReq;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;
import com.diegodev.backendgenialacademy.auth.services.AuthService;
import com.diegodev.backendgenialacademy.dtos.responses.UserRes;
import com.diegodev.backendgenialacademy.exceptions.RequestException;
import com.diegodev.backendgenialacademy.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthRes> register(@RequestBody UserReq request) {
        Optional<UserRes> userFoundByUsername = userService.findByUsername(request.username());
        Optional<UserRes> userFoundByEmail = userService.findByEmail(request.email());
        if (userFoundByUsername.isPresent())
            throw new RequestException(HttpStatus.CONFLICT, "Error: Username is already in use");
        if (userFoundByEmail.isPresent())
            throw new RequestException(HttpStatus.CONFLICT ,"Error: Email is already in use");
        try {
            AuthRes authRes = authService.register(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(authRes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthRes> login(@RequestBody UserLoginReq request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}