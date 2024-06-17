package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.requests.UniversityReq;
import com.diegodev.backendgenialacademy.dtos.responses.UniversityRes;

import java.util.List;

public interface UniversityService {
    UniversityRes create(UniversityReq universityReq);
    UniversityRes findById(Long id);
    List<UniversityRes> findAll();
}
