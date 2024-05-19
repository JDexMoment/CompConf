package Controller;

import Model.Computer;
import Repository.ComputerRepository;
import Service.ComplectService;
import Service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computer")
public class ComputerController {
    private final ComplectService complectService;

    private final ComputerService computerService;

    @GetMapping
    public ResponseEntity<List<Computer>> getComputers() {
        List<Computer> computers = computerService.getComputers();
        return ResponseEntity.ok(computers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable Long id) {
        Optional<Computer> computer = computerService.getComputerById(id);
        return computer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{Computerid}/CPU/{CPUid}")
    public ResponseEntity<String> setCPUNameById(@PathVariable Long Computerid, @PathVariable Long CPUid) {
        return complectService.setCPUNameById(CPUid).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
