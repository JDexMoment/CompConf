package Controller;

import Model.Complect;
import Service.ComplectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complect")
@Slf4j
public class ComplectPostController {
    private final ComplectService complectService;

    @PostMapping
    public ResponseEntity<Void> registerComplect(@RequestBody Complect complect) {
        log.info("Received POST request with complect: {}", complect);
        complectService.registerComplect(complect);
        return ResponseEntity.ok().build();
    }
}
