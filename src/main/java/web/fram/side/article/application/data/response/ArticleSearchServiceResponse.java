package web.fram.side.article.application.data.response;

import java.time.LocalDateTime;

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
                article.getCreatedAt(),
                article.getUpdatedAt());
    }
}
