package web.fram.side.article.handler.api.data.response;

import web.fram.side.article.application.data.response.ArticleSearchServiceResponse;

public record ArticleSearchWebResponse(long id, String title, String author, String desc) {

    public ArticleSearchWebResponse(final ArticleSearchServiceResponse serviceResponse) {
        this(serviceResponse.id(), serviceResponse.title(), serviceResponse.author(), serviceResponse.description());
    }
}
