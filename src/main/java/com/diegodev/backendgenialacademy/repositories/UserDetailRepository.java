package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long> {
    UserDetailEntity findByUser_UserId(Long userId);
}
