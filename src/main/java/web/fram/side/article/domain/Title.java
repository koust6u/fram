package web.fram.side.article.domain;

import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Title {

    private static final int TITLE_MIN_LENGTH = 2;
    private static final int TITLE_MAX_LENGTH = 100;

    private String title;

    public Title(final String title) {
        validate(title);
        this.title = title;
    }

    private void validate(final String title) {
        if (title.length() < TITLE_MIN_LENGTH || title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException("제목은 %d ~ %d 범위 사이여야한다.".formatted(TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        }
    }
}
