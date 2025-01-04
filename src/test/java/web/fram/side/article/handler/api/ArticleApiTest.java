package web.fram.side.article.handler.api;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import web.dummy.ArticleDummies;
import web.fixture.AcceptanceFixture;

class ArticleApiTest extends AcceptanceFixture {

    @Test
    @DisplayName("글을 생성한다.")
    void create_article() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(ArticleDummies.articleCreateWebRequest())

                .when()
                .post("/api/article")

                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    @DisplayName("작성글에 제목이 빠지면 400")
    void return_400_when_title_is_blank() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(Map.of("author", "작성자 ", "title", "", "desc", "내용"))

                .when()
                .post("/api/article")

                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    @DisplayName("작성글에 작성자가 빠지면 400")
    void return_400_when_author_is_blank() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(Map.of("author", "", "title", "제목", "desc", "내용"))

                .when()
                .post("/api/article")

                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    @DisplayName("작성글에 작성자가 빠지면 400")
    void return_400_when_author_is_desc() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(Map.of("author", "작성자", "title", "제목", "desc", ""))

                .when()
                .post("/api/article")

                .then()
                .assertThat()
                .statusCode(400);
    }
}
