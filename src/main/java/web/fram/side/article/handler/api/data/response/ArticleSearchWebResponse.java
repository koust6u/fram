package web.fram.side.article.handler.api.data.response;

import java.time.LocalDateTime;

import web.fram.side.article.application.data.response.ArticleSearchServiceResponse;

public record ArticleSearchWebResponse(long id, String title, String author, String content, LocalDateTime createdAt,
                                       LocalDateTime modifiedAt) {

    public ArticleSearchWebResponse(final ArticleSearchServiceResponse serviceResponse) {
        this(serviceResponse.id(),
                serviceResponse.title(),
                serviceResponse.author(),
                serviceResponse.content(),
                serviceResponse.createdAt(),
                serviceResponse.modifiedAt());
    }
}
