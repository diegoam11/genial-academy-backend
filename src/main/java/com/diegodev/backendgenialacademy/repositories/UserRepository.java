package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.UserDetailEntity;
import com.diegodev.backendgenialacademy.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
