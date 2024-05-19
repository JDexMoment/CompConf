package Controller;

import Model.Complect;
import Service.ComplectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complect")
public class ComplectPostController {
    private final ComplectService complectService;

    @PostMapping
    ResponseEntity post(@RequestBody Complect complect) {
        complectService.registerComplect(complect);
        return ResponseEntity.ok().build();
    }
}
