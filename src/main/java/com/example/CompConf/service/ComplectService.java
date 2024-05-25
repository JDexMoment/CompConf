package com.example.CompConf.service;

import com.example.CompConf.model.Complect;

import java.util.List;
import java.util.Optional;

public interface ComplectService {

    List<Complect> getCPU();
    List<Complect> getGPU();
    List<Complect> getMotherBoard();
    List<Complect> getCooler();
    List<Complect> getRAM();
    List<Complect> getSSD();
    List<Complect> getHDD();
    List<Complect> getComputerCase();
    List<Complect> getPowerUnit();

    Optional<Complect> getComplectById(Long id);

    void registerComplect(Complect complect);

}
