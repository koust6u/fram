package web.fram.side.article.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import web.dummy.ArticleDummies;
import web.fram.side.article.domain.Article;

class ArticleModifierTest {

    @Test
    @DisplayName("작성글을 수정한다.")
    void create_article() {
        // given
        final String title = "안녕하세요";
        final String content = "가나다라마바사아자차가파타";

        // when & then
        assertThatCode(() -> new ArticleModifier(content, title))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("작성글의 내용의 길이가 10자 미만이면 예외를 발생시킨다.")
    void throw_exception_when_description_length_less_then_10() {
        // given
        final String title = "안녕하세요";
        final String content = "123456789";

        // when & then
        assertThatThrownBy(() -> new ArticleModifier(content, title))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("작성글의 내용의 길이가 4096자 초과이면 예외를 발생시킨다.")
    void throw_exception_when_description_length_greater_then_4096() {
        // given
        final String title = "안녕하세요";
        final String content = "1".repeat(4097);

        // when & then
        assertThatThrownBy(() -> new ArticleModifier(content, title))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제목이 2자 미만이면 에외를 던진다.")
    void throw_exception_when_title_length_less_then_2() {
        // given
        final String title = "1";
        final String content = "가나다라마바사아자차가파타";

        // when
        assertThatThrownBy(() -> new ArticleModifier(content, title))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제목이 200자 초과하면 에외를 던진다.")
    void throw_exception_when_title_length_greater_then_10() {
        // given
        final String title = "1".repeat(201);
        final String content = "가나다라마바사아자차가파타";

        // when
        assertThatThrownBy(() -> new ArticleModifier(content, title))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수정한다.")
    void modify() {
        // given
        final String title = "수정했어요.";
        final String content = "수정한 내용이 있을겁니다.";
        final Article article = ArticleDummies.article();
        final ArticleModifier sut = new ArticleModifier(content, title);

        // when
        sut.modify(article);

        // then
        assertThat(article.getContentAsString()).isEqualTo(content);
        assertThat(article.getTitleAsString()).isEqualTo(title);
    }
}
