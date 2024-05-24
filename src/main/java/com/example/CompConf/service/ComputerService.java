package com.example.CompConf.service;

import com.example.CompConf.model.Computer;

import java.util.List;
import java.util.Optional;

public interface ComputerService {
    List<Computer> getComputers();
    Optional<Computer> getComputerById(Long id);
}
