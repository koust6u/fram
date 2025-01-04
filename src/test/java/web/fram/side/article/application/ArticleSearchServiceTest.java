package web.fram.side.article.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import web.dummy.ArticleDummies;
import web.fram.side.article.application.data.response.ArticleSearchServiceResponse;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.repository.ArticleRepository;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class ArticleSearchServiceTest {

    @Autowired
    private ArticleSearchService articleSearchService;

    @Autowired
    private ArticleRepository articleRepository;

    @AfterEach
    void tearDown() {
        articleRepository.deleteAll();
    }

    @Test
    @DisplayName("작성글 단건 읽어온다.")
    void read_specific_article() {
        // given
        final Article article = articleRepository.save(ArticleDummies.article());

        // when
        final ArticleSearchServiceResponse response = articleSearchService.searchSingle(article.getId());

        // then
        final ArticleSearchServiceResponse expected = new ArticleSearchServiceResponse
                (article.getId(), article.getTitleAsString(), article.getAuthor(), article.getContentAsString());
        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("존재하지 않는 작성글을 조회하면 예외를 던진다.")
    void throw_exception_when_search_does_not_exist_article() {
        // given
        final long doesNotExistId = Long.MAX_VALUE;

        // when & then
        assertThatThrownBy(() -> articleSearchService.searchSingle(doesNotExistId))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    @DisplayName("10건씩 페이지 조회를 한다.")
    void search_page_item_10() {
        // given
        for (int i = 0; i < 11; i++) {
            articleRepository.save(ArticleDummies.article());
        }

        // when
        final List<ArticleSearchServiceResponse> actual = articleSearchService.searchPaging(0);

        // then
        assertThat(actual).hasSize(10);
    }

    @Test
    @DisplayName("10건씩 페이지 조회를 한다. - 10건 미만")
    void search_page_item_less_then_10() {
        // given
        for (int i = 0; i < 5; i++) {
            articleRepository.save(ArticleDummies.article());
        }

        // when
        final List<ArticleSearchServiceResponse> actual = articleSearchService.searchPaging(0);

        // then
        assertThat(actual).hasSize(5);
    }

    @Test
    @DisplayName("10건씩 페이지 조회를 한다. - 10건 초가")
    void search_page_item_less_then_14() {
        // given
        for (int i = 0; i < 14; i++) {
            articleRepository.save(ArticleDummies.article());
        }

        // when
        final List<ArticleSearchServiceResponse> actual = articleSearchService.searchPaging(1);

        // then
        assertThat(actual).hasSize(4);
    }
}
