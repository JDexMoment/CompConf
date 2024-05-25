package com.example.CompConf.service;

import com.example.CompConf.model.Complect;
import com.example.CompConf.model.Computer;

import java.util.Optional;

public interface ComputerService {
    void createComputer(Computer computer);
    void deleteComputer(Long id);
    Computer updateComputer(Long id, Computer computer);
    //Optional<Computer> getComputerDetailsById(Long id);
    Optional<Complect> getComplectById(Long id);
    Optional<Computer> getComputerById(Long id);
}
