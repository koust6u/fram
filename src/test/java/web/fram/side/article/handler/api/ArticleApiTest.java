package web.fram.side.article.handler.api;

import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import web.dummy.ArticleDummies;
import web.fixture.AcceptanceFixture;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.repository.ArticleRepository;

class ArticleApiTest extends AcceptanceFixture {

    @Autowired
    private ArticleRepository articleRepository;

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
                .body(Map.of("author", "작성자 ", "title", "", "content", "내용"))

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
                .body(Map.of("author", "", "title", "제목", "content", "내용"))

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
                .body(Map.of("author", "작성자", "title", "제목", "content", ""))

                .when()
                .post("/api/article")

                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    @DisplayName("작성글 단건 조회한다.")
    void search_single_article() {
        // given
        final Article article = articleRepository.save(ArticleDummies.article());

        // when & then
        RestAssured
                .given()

                .when()
                .pathParam("id", article.getId())
                .get("/api/article/{id}")

                .then()
                .assertThat()
                .statusCode(200)
                .body("title", is("제목"))
                .body("author", is("작성자"))
                .body("content", is("내용은 10자이상이여야합니다."));
    }

    @Test
    @DisplayName("작성글을 묶음으로 조회한다.")
    void search_article_by_bunch() {
        // given
        create_article();
        create_article();
        create_article();

        // when & then
        RestAssured
                .given()

                .when()
                .pathParam("pageId", 0)
                .get("/api/article/page/{pageId}")

                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(3));
    }

    @Test
    @DisplayName("작성 글을 수정한다.")
    void modify_article() {
        // given
        final Article article = articleRepository.save(ArticleDummies.article());

        // when & then
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(ArticleDummies.articleModifyWebRequest())

                .when()
                .pathParam("id", article.getId())
                .patch("/api/article/{id}")

                .then()
                .assertThat()
                .statusCode(204);
    }

    @Test
    @DisplayName("작성글을 삭제한다.")
    void delete_article() {
        // given
        final Article article = articleRepository.save(ArticleDummies.article());

        // when & then
        RestAssured
                .given()

                .when()
                .pathParam("id", article.getId())
                .delete("/api/article/{id}")

                .then()
                .assertThat()
                .statusCode(204);
    }
}
