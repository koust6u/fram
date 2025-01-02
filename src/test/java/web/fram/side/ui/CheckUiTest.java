package web.fram.side.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import web.fixture.AcceptanceFixture;

class CheckUiTest extends AcceptanceFixture {

    @Test
    @DisplayName("헬스 체크 페이지")
    void healthCheckPage() {
        RestAssured
                .given()

                .when()
                .get("/health")

                .then()
                .assertThat()
                .statusCode(200);
    }
}
