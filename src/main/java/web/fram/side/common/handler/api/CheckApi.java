package web.fram.side.common.handler.api;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import web.fram.side.common.handler.api.data.HealthMessage;
import web.fram.side.common.handler.api.docs.CheckApiDocs;

@RestController
public class CheckApi implements CheckApiDocs {

    @GetMapping(value = "/health")
    public ResponseEntity<HealthMessage> checkHealth() {
        final HealthMessage health = new HealthMessage("OK", LocalDateTime.now());
        return ResponseEntity.ok(health);
    }
}
