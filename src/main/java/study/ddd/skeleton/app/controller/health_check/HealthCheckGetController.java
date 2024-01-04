package study.ddd.skeleton.app.controller.health_check;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthCheckGetController {

    @GetMapping("/health-check")
    public ResponseEntity handle() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "ok");

        return ResponseEntity.ok(status);
    }

}
