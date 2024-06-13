package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
    List<ProvinceEntity> findAllByDepartment_DepartmentId(Long departmentId);
}
