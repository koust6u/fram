package web.fram.side.api.data;

import java.time.LocalDateTime;

public record HealthMessage(String health, LocalDateTime serverTime) {
}
