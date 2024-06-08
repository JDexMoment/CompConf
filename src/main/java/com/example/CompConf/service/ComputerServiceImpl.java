package com.example.CompConf.service;

import com.example.CompConf.model.Complect;
import com.example.CompConf.model.Computer;
import com.example.CompConf.repository.ComplectRepository;
import com.example.CompConf.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ComputerServiceImpl implements ComputerService {
    private final ComputerRepository computerRepository;

    private final ComplectRepository complectRepository;

    @Override
    public void createComputer(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void deleteComputer(Long id) {
        computerRepository.deleteById(id);
    }

    @Override
    public Computer updateComputer(Long id, Computer computerDetails) {
        return computerRepository.findById(id)
                .map(computer -> {
                    computer.setWishList(computerDetails.getWishList());
                    computer.setCpu(computerDetails.getCpu());
                    computer.setGpu(computerDetails.getGpu());
                    computer.setMotherBoard(computerDetails.getMotherBoard());
                    computer.setCooler(computerDetails.getCooler());
                    computer.setRam(computerDetails.getRam());
                    computer.setCountRAM(computerDetails.getCountRAM());
                    computer.setSsd(computerDetails.getSsd());
                    computer.setCountSSD(computerDetails.getCountSSD());
                    computer.setHdd(computerDetails.getHdd());
                    computer.setCountHDD(computerDetails.getCountHDD());
                    computer.setComputerCase(computerDetails.getComputerCase());
                    computer.setPowerUnit(computerDetails.getPowerUnit());
                    computer.setTotalCost(computerDetails.getTotalCost());
                    return computerRepository.save(computer);
                })
                .orElseThrow(() -> new RuntimeException("Computer not found with id " + id));
    }

    @Override
    public Optional<Computer> getComputerById(Long id) {
        return computerRepository.findById(id);
    }

}
