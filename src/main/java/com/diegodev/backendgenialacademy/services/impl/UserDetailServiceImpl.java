package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.UserDetailDTO;
import com.diegodev.backendgenialacademy.entities.DistrictEntity;
import com.diegodev.backendgenialacademy.entities.UserDetailEntity;
import com.diegodev.backendgenialacademy.entities.UserEntity;
import com.diegodev.backendgenialacademy.repositories.UserDetailRepository;
import com.diegodev.backendgenialacademy.repositories.UserRepository;
import com.diegodev.backendgenialacademy.services.UserDetailService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserRepository userRepository) {
        this.userDetailRepository = userDetailRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailEntity findByUserId(Long userId) {
        return userDetailRepository.findByUser_UserId(userId);
    }

    @Override
    public UserDetailEntity addDetail(UserDetailDTO userDetailDTO) {
        UserDetailEntity userDetailEntity = new UserDetailEntity();
        UserEntity userEntity = userRepository.findById(userDetailDTO.userId()).orElseThrow();
        DistrictEntity districtEntity = 

        userDetailEntity.setUser(userEntity);
        userDetailEntity.setPhone();
    }
}
