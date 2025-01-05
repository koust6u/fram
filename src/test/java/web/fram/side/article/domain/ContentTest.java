package web.fram.side.article.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContentTest {


    @Test
    @DisplayName("작성글의 내용의 길이가 10자 미만이면 예외를 발생시킨다.")
    void throw_exception_when_description_length_less_then_10() {
        // given
        final String content = "123456789";

        // when & then
        assertThatThrownBy(() -> new Content(content))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("작성글의 내용의 길이가 4096자 초과이면 예외를 발생시킨다.")
    void throw_exception_when_description_length_greater_then_4096() {
        // given
        final String content = "1".repeat(4097);

        // when & then
        assertThatThrownBy(() -> new Content(content))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
