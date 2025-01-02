package web.fram.side.common.controller.api;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.net.URI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import web.fixture.AcceptanceFixture;

class CheckApiTest extends AcceptanceFixture {

    @Test
    @DisplayName("헬스 체크 API 200 반환")
    void checkHealth() {
        RestAssured
                .given()

                .when()
                .get(URI.create("/api/health"))

                .then()
                .assertThat()
                .statusCode(200)
                .body("health", is("OK"))
                .body("serverTime", notNullValue());
    }
}
