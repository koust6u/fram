package web.fixture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import web.fram.side.article.domain.repository.ArticleRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AcceptanceFixture {

    @LocalServerPort
    int randomPort;

    @Autowired
    private ArticleRepository articleRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = randomPort;
    }

    @AfterEach
    void tearDown() {
        articleRepository.deleteAll();
    }
}
