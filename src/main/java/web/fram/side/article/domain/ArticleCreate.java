package web.fram.side.article.domain;

public class ArticleCreate {

    private static final int TITLE_MAX_LENGTH = 100;
    private static final int TITLE_MIN_LENGTH = 2;
    private static final int DESC_MIN_LENGTH = 10;
    private static final int DESC_MAX_LENGTH = 4096;

    private final String title;
    private final String author;
    private final String description;

    public ArticleCreate(final String title, final String author, final String description) {
        validate(title, description);
        this.title = title;
        this.author = author;
        this.description = description;
    }

    private void validate(final String title, final String description) {
        if (title.length() < TITLE_MIN_LENGTH || title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException("제목은 %d ~ %d 범위 사이여야한다.".formatted(TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        }
        if (description.length() < DESC_MIN_LENGTH || description.length() > DESC_MAX_LENGTH) {
            throw new IllegalArgumentException("작성 내용은 %d ~ %d 범위 사이여야한다.".formatted(DESC_MIN_LENGTH, DESC_MAX_LENGTH));
        }
    }

    public Article toEntity() {
        return new Article(title, author, description);
    }
}
