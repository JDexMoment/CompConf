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

    private final List<Long> CPUs = new ArrayList<>();
    private final List<Long> GPUs = new ArrayList<>();
    private final List<Long> MBs = new ArrayList<>();
    private final List<Long> Coolers = new ArrayList<>();
    private final List<Long> RAMs = new ArrayList<>();
    private final List<Long> SSDs = new ArrayList<>();
    private final List<Long> HDDs = new ArrayList<>();
    private final List<Long> CCs = new ArrayList<>();
    private final List<Long> PUs = new ArrayList<>();

    @Override
    public Optional<String> getNameById(Long id) {
        Optional<Complect> complectOpt = complectRepository.findById(id);
        if (complectOpt.isPresent()) {
            Complect complect = complectOpt.get();
            return Optional.of(complect.getName());
        } else {
            return Optional.empty();
        }
    }

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

    @Override
    public Optional<String> setCPUNameById(Long id) {
        if (getCPUTypeById(id)) {
            // Добавляем ID CPU в список CPUs, если его там еще нет
            if (!CPUs.contains(id)) {
                CPUs.add(id);
            }
            // Возвращаем имя CPU
            return getNameById(id);
        } else {
            return Optional.of("Этот id не является CPU");
        }
    }

    @Override
    public Optional<String> setGPUNameById(Long id) {
        if (getGPUTypeById(id)) {
            if (!GPUs.contains(id)) {
                GPUs.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является GPU");
        }
    }

    @Override
    public Optional<String> setMotherBoardNameById(Long id) {
        if (getMotherBoardTypeById(id)) {
            if(!MBs.contains(id)) {
                MBs.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является Mother Board");
        }
    }

    @Override
    public Optional<String> setCoolerNameById(Long id) {
        if (getCoolerTypeById(id)) {
            if (!Coolers.contains(id)) {
                Coolers.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является Cooler");
        }
    }

    @Override
    public Optional<String> setRAMNameById(Long id) {
        if (getRAMTypeById(id)) {
            if (!RAMs.contains(id)) {
                RAMs.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является RAM");
        }
    }

    @Override
    public Optional<String> setSSDNameById(Long id) {
        if (getSSDTypeById(id)) {
            if (!SSDs.contains(id)) {
                SSDs.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является SSD");
        }
    }

    @Override
    public Optional<String> setHDDNameById(Long id) {
        if (getHDDTypeById(id)) {
            if (!HDDs.contains(id)) {
                HDDs.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является HDD");
        }
    }

    @Override
    public Optional<String> setComputerCaseNameById(Long id) {
        if (getComputerCaseTypeById(id)) {
            if (!CCs.contains(id)) {
                CCs.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является Computer Case");
        }
    }

    @Override
    public Optional<String> setPowerUnitNameById(Long id) {
        if (getPowerUnitTypeById(id)) {
            if (!PUs.contains(id)) {
                PUs.add(id);
            }
            return getNameById(id);
        }
        else {
            return Optional.ofNullable("Этот id не является Power Unit");
        }
    }

    @Override
    public boolean getCPUTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "CPU".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getGPUTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "GPU".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getMotherBoardTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "MotherBoard".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getCoolerTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "Cooler".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getRAMTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "RAM".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getSSDTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "SSD".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getHDDTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "HDD".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getComputerCaseTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "ComputerCase".equals(foundComplect.getType());
        }
        return false;
    }

    @Override
    public boolean getPowerUnitTypeById(Long id) {
        Optional<Complect> complect = complectRepository.findById(id);
        if (complect.isPresent()) {
            Complect foundComplect = complect.get();
            return "PowerUnit".equals(foundComplect.getType());
        }
        return false;
    }
}
