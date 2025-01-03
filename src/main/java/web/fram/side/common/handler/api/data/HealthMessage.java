package web.fram.side.common.handler.api.data;

import java.time.LocalDateTime;

public record HealthMessage(String health, LocalDateTime serverTime) {
}
