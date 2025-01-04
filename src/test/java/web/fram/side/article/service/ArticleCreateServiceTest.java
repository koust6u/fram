package web.fram.side.article.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import web.dummy.ArticleDummies;
import web.fram.side.article.domain.repository.ArticleRepository;
import web.fram.side.article.service.data.request.ArticleCreateServiceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class ArticleCreateServiceTest {

    @Autowired
    private ArticleCreateService articleCreateService;

    @Autowired
    private ArticleRepository articleRepository;

    @AfterEach
    void tearDown() {
        articleRepository.deleteAll();
    }

    @Test
    @DisplayName("작성글을 생성한다.")
    void create_article() {
        // given
        final ArticleCreateServiceRequest request = ArticleDummies.articleCreateServiceRequest();

        // when
        long id = articleCreateService.create(request);

        // then
        assertThat(articleRepository.findById(id))
                .isPresent();
    }
}
