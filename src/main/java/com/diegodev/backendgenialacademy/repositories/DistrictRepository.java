package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
    List<DistrictEntity> findAllByProvinceId(Long provinceId);
}
