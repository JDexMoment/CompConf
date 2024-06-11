package com.example.CompConf.service;

import com.example.CompConf.model.Complect;

import java.util.List;
import java.util.Optional;

public interface ComplectService {

    List<Complect> getComplectsByType(String type);

    Optional<Complect> getComplectById(Long id);

    void registerComplect(Complect complect);

}
