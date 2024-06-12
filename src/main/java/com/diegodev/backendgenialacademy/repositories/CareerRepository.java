package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.CareerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<CareerEntity, Long> {

}
