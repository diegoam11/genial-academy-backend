package com.diegodev.backendgenialacademy.auth;

import com.diegodev.backendgenialacademy.dtos.responses.AuthRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserLoginReq;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;
import com.diegodev.backendgenialacademy.auth.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthRes register(@RequestBody UserReq request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthRes login(@RequestBody UserLoginReq userLoginReq){
        return authService.authenticate(userLoginReq);
    }
}