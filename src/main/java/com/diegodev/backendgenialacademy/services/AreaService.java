package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.requests.AreaReq;
import com.diegodev.backendgenialacademy.dtos.responses.AreaRes;

import java.util.List;

public interface AreaService {
    AreaRes create(AreaReq areaReq);
    List<AreaRes> findAll();
    List<AreaRes> findByUniId(Long id);
}
