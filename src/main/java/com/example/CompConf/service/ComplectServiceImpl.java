package com.example.CompConf.service;

import com.example.CompConf.model.Complect;
import com.example.CompConf.repository.ComplectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ComplectServiceImpl implements ComplectService {

    private final ComplectRepository complectRepository;

    @Override
    public Optional<Complect> getComplectById(Long id) {
        return complectRepository.findById(id);
    }

    @Override
    public void registerComplect(Complect complect) {
        complectRepository.save(complect);
    }

    @Override
    public List<Complect> getCPU() {
        return complectRepository.findByType("CPU");
    }

    @Override
    public List<Complect> getGPU() {
        return complectRepository.findByType("GPU");
    }

    @Override
    public List<Complect> getMotherBoard() {
        return complectRepository.findByType("MotherBoard");
    }

    @Override
    public List<Complect> getCooler() {
        return complectRepository.findByType("Cooler");
    }

    @Override
    public List<Complect> getRAM() {
        return complectRepository.findByType("RAM");
    }

    @Override
    public List<Complect> getSSD() {
        return complectRepository.findByType("SSD");
    }

    @Override
    public List<Complect> getHDD() {
        return complectRepository.findByType("HDD");
    }

    @Override
    public List<Complect> getComputerCase() {
        return complectRepository.findByType("ComputerCase");
    }

    @Override
    public List<Complect> getPowerUnit() {
        return complectRepository.findByType("PowerUnit");
    }


}
