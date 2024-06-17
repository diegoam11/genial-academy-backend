package com.diegodev.backendgenialacademy.auth.services;

import com.diegodev.backendgenialacademy.dtos.responses.AuthRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserLoginReq;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;
import com.diegodev.backendgenialacademy.entities.UserEntity;
import com.diegodev.backendgenialacademy.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthRes register(UserReq request){
        UserEntity user = new UserEntity();
        user.setName(request.name());
        user.setLastname(request.lastname());
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));

        user.setRole(request.role());
        user = userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthRes(token);
    }

    public AuthRes authenticate(UserLoginReq request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        UserEntity user = userRepository.findByUsername(request.username()).orElseThrow();
        String token = jwtService.generateToken(user);

        return new AuthRes(token);
    }
}