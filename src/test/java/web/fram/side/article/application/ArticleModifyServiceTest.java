package web.fram.side.article.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import web.dummy.ArticleDummies;
import web.fram.side.article.application.data.request.ArticleModifyAppRequest;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.repository.ArticleRepository;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class ArticleModifyServiceTest {

    @Autowired
    private ArticleModifyService articleModifyService;

    @Autowired
    private ArticleRepository articleRepository;

    @AfterEach
    void tearDown() {
        articleRepository.deleteAll();
    }

    @Test
    @DisplayName("작성글을 수정한다.")
    void modify_article() {
        // given
        final String changeTitle = "수정된 제목";
        final String changeContent = "수정된 글의 내용입니다.";
        final Article article = ArticleDummies.article();
        articleRepository.save(article);

        // when
        articleModifyService.modify(new ArticleModifyAppRequest(article.getId(), changeTitle, changeContent));

        // then
        final Article actual = articleRepository.findById(article.getId())
                .orElseThrow();
        assertThat(actual.getTitleAsString()).isEqualTo(changeTitle);
        assertThat(actual.getContentAsString()).isEqualTo(changeContent);
    }

    @Test
    @DisplayName("없는 작성글 수정 요청시 예외를 던진다.")
    void throw_exception_when_article_id_does_not_exist() {
        // given
        final String changeTitle = "수정된 제목";
        final String changeContent = "수정된 글의 내용입니다.";
        final long doesNotExistId = Long.MAX_VALUE;

        //when & then
        final ArticleModifyAppRequest request = new ArticleModifyAppRequest(doesNotExistId, changeTitle, changeContent);
        assertThatThrownBy(() -> articleModifyService.modify(request))
                .isInstanceOf(EntityNotFoundException.class);
    }
}
