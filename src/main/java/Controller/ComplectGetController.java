package Controller;

import Model.Complect;
import Service.ComplectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complect")
public class ComplectGetController {
    private final ComplectService complectService;

    @GetMapping("/{id}")
    ResponseEntity<Complect> getComplect(@PathVariable Long id) {
        return complectService.getComplectById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/CPU")
    public ResponseEntity<List<Complect>> getCPU() {
        List<Complect> Complects = complectService.getCPU();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/GPU")
    public ResponseEntity<List<Complect>> getGPU() {
        List<Complect> Complects = complectService.getGPU();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/MB")
    public ResponseEntity<List<Complect>> getMB() {
        List<Complect> Complects = complectService.getMotherBoard();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/Cooler")
    public ResponseEntity<List<Complect>> getCooler() {
        List<Complect> Complects = complectService.getCooler();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/RAM")
    public ResponseEntity<List<Complect>> getRAM() {
        List<Complect> Complects = complectService.getRAM();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/SSD")
    public ResponseEntity<List<Complect>> getSSD() {
        List<Complect> Complects = complectService.getSSD();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/HDD")
    public ResponseEntity<List<Complect>> getHDD() {
        List<Complect> Complects = complectService.getHDD();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/CC")
    public ResponseEntity<List<Complect>> getCC() {
        List<Complect> Complects = complectService.getComputerCase();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }

    @GetMapping("/PU")
    public ResponseEntity<List<Complect>> getPU() {
        List<Complect> Complects = complectService.getPowerUnit();
        return new ResponseEntity<>(Complects, HttpStatus.OK);
    }
}
