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
    public Optional<Complect> getComplectById(Long id) {
        return complectRepository.findById(id);
    }

    @Override
    public Optional<Computer> getComputerById(Long id) {
        return computerRepository.findById(id);
    }

//    public Optional<Computer> getComputerDetailsById(Long id) {
//        return computerRepository.findById(id).map(computer -> {
//            computer.setCpu(Objects.requireNonNull(getComplectById(computer.getCpu().getId()).orElse(null)));
//            computer.setGpu(Objects.requireNonNull(getComplectById(computer.getGpu().getId()).orElse(null)));
//            computer.setMotherBoard(Objects.requireNonNull(getComplectById(computer.getMotherBoard().getId()).orElse(null)));
//            computer.setCooler(Objects.requireNonNull(getComplectById(computer.getCooler().getId()).orElse(null)));
//            computer.setRam(Objects.requireNonNull(getComplectById(computer.getRam().getId()).orElse(null)));
//            computer.setSsd(Objects.requireNonNull(getComplectById(computer.getSsd().getId()).orElse(null)));
//            computer.setHdd(Objects.requireNonNull(getComplectById(computer.getHdd().getId()).orElse(null)));
//            computer.setComputerCase(Objects.requireNonNull(getComplectById(computer.getComputerCase().getId()).orElse(null)));
//            computer.setPowerUnit(Objects.requireNonNull(getComplectById(computer.getPowerUnit().getId()).orElse(null)));
//            return computer;
//        });
//    }



}
