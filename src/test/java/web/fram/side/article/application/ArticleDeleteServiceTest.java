package web.fram.side.article.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import web.dummy.ArticleDummies;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.repository.ArticleRepository;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class ArticleDeleteServiceTest {

    @Autowired
    private ArticleDeleteService articleDeleteService;

    @Autowired
    private ArticleRepository articleRepository;

    @AfterEach
    void tearDown() {
        articleRepository.deleteAll();
    }

    @Test
    @DisplayName("작성글을 삭제한다.")
    void delete_article() {
        // given
        final Article article = articleRepository.save(ArticleDummies.article());

        // when
        articleDeleteService.delete(article.getId());

        // then
        assertThat(articleRepository.findById(article.getId())).isEmpty();
    }

}
