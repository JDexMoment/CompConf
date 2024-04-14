package Controller;

import Model.*;
import Service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {
    private final ComputerService computerService;

    ResponseEntity<String> getCPUNameById(Long id) {
        Optional<CPU> CPUOptional = ComputerService.getCPUNameById(id);
        if (CPUOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            String Name = CPUOptional.get().getName();
            return ResponseEntity.ok(Name);
        }
    }

    ResponseEntity<String> getGPUNameById(Long id) {
        Optional<GPU> GPUOptional = ComputerService.getGPUNameById(id);
        if (GPUOptional.isPresent()) {
            String Name = GPUOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ResponseEntity<String> getMotherBoardNameById(Long id) {
        Optional<MotherBoard> MotherBoardOptional = ComputerService.getMotherBoardNameById(id);
        if (MotherBoardOptional.isPresent()) {
            String Name = MotherBoardOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ResponseEntity<String> getCoolerNameById(Long id) {
        Optional<Cooler> CoolerOptional = ComputerService.getCoolerNameById(id);
        if (CoolerOptional.isPresent()) {
            String Name = CoolerOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ResponseEntity<String> getRAMNameById(Long id) {
        Optional<RAM> RAMOptional = ComputerService.getRAMNameById(id);
        if (RAMOptional.isPresent()) {
            String Name = RAMOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ResponseEntity<String> getSSDNameById(Long id) {
        Optional<SSD> SSDOptional = ComputerService.getSSDNameById(id);
        if (SSDOptional.isPresent()) {
            String Name = SSDOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ResponseEntity<String> getHDDNameById(Long id) {
        Optional<HDD> HDDOptional = ComputerService.getHDDNameById(id);
        if (HDDOptional.isPresent()) {
            String Name = HDDOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ResponseEntity<String> getComputerCaseNameById(Long id) {
        Optional<ComputerCase> ComputerCaseOptional = ComputerService.getComputerCaseNameById(id);
        if (ComputerCaseOptional.isPresent()) {
            String Name = ComputerCaseOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ResponseEntity<String> getPowerUnitNameById(Long id) {
        Optional<PowerUnit> PowerUnitOptional = ComputerService.getPowerUnitNameById(id);
        if (PowerUnitOptional.isPresent()) {
            String Name = PowerUnitOptional.get().getName();
            return ResponseEntity.ok(Name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
