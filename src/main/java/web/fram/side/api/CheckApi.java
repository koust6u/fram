package web.fram.side.api;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.fram.side.api.data.HealthMessage;
import web.fram.side.api.docs.CheckApiDocs;

@RestController
@RequestMapping("/api")
public class CheckApi implements CheckApiDocs {

    @GetMapping(value = "/health")
    public ResponseEntity<HealthMessage> checkHealth() {
        final HealthMessage health = new HealthMessage("OK", LocalDateTime.now());
        return ResponseEntity.ok(health);
    }
}
