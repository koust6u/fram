package web.fram.side.article.domain.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArticleCreatorTest {

    @Test
    @DisplayName("작성글을 생성한다.")
    void create_article() {
        // given
        final String title = "안녕하세요";
        final String content = "가나다라마바사아자차가파타";
        final String author = "프람";

        // when & then
        assertThatCode(() -> new ArticleCreator(title, author, content))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("작성글의 내용의 길이가 10자 미만이면 예외를 발생시킨다.")
    void throw_exception_when_description_length_less_then_10() {
        // given
        final String title = "안녕하세요";
        final String content = "123456789";
        final String author = "프람";

        // when & then
        assertThatThrownBy(() -> new ArticleCreator(title, author, content))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("작성글의 내용의 길이가 4096자 초과이면 예외를 발생시킨다.")
    void throw_exception_when_description_length_greater_then_4096() {
        // given
        final String title = "안녕하세요";
        final String content = "1".repeat(4097);
        final String author = "프람";

        // when & then
        assertThatThrownBy(() -> new ArticleCreator(title, author, content))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제목이 2자 미만이면 에외를 던진다.")
    void throw_exception_when_title_length_less_then_2() {
        // given
        final String title = "1";
        final String content = "가나다라마바사아자차가파타";
        final String author = "프람";

        // when
        assertThatThrownBy(() -> new ArticleCreator(title, author, content))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제목이 200자 초과하면 에외를 던진다.")
    void throw_exception_when_title_length_greater_then_10() {
        // given
        final String title = "1".repeat(201);
        final String content = "가나다라마바사아자차가파타";
        final String author = "프람";

        // when
        assertThatThrownBy(() -> new ArticleCreator(title, author, content))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
