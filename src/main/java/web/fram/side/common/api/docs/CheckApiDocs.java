package web.fram.side.common.api.docs;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import web.fram.side.common.api.data.HealthMessage;

@Tag(name = "관리자 확인용 API")
public interface CheckApiDocs {

    @Operation(summary = "헬스 체크")
    @ApiResponse(responseCode = "200 OK", description = "서버 OK")
    ResponseEntity<HealthMessage> checkHealth();
}
