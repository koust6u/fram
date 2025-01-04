package web.fram.side.article.domain;

import java.util.Objects;

import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {

    private static final int DESC_MIN_LENGTH = 10;
    private static final int DESC_MAX_LENGTH = 4096;

    private String content;

    public Content(final String content) {
        validate(content);
        this.content = content;
    }

    private void validate(final String content) {
        if (content.length() < DESC_MIN_LENGTH || content.length() > DESC_MAX_LENGTH) {
            throw new IllegalArgumentException("작성 내용은 %d ~ %d 범위 사이여야한다.".formatted(DESC_MIN_LENGTH, DESC_MAX_LENGTH));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Content content1 = (Content) o;
        return Objects.equals(content, content1.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
