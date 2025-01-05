package web.fram.side.article.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TitleTest {

    @Test
    @DisplayName("제목이 2자 미만이면 에외를 던진다.")
    void throw_exception_when_title_length_less_then_2() {
        // given
        final String title = "1";

        // when
        assertThatThrownBy(() -> new Title(title))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제목이 100자 초과하면 에외를 던진다.")
    void throw_exception_when_title_length_greater_then_10() {
        // given
        final String title = "1".repeat(201);

        // when
        assertThatThrownBy(() -> new Title(title))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
