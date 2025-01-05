package web.fram.side.article.application.data.response;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import web.fram.side.article.domain.Article;

public record ArticleSearchServiceResponse(long id,
                                           String title,
                                           String author,
                                           String content,
                                           LocalDateTime createdAt,
                                           LocalDateTime modifiedAt) {

    public ArticleSearchServiceResponse(Article article) {
        this(article.getId(),
                article.getTitleAsString(),
                article.getAuthor(),
                article.getContentAsString(),
                article.getCreatedAt().truncatedTo(ChronoUnit.SECONDS),
                article.getUpdatedAt().truncatedTo(ChronoUnit.SECONDS));
    }
}
