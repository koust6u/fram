package web.fram.side.article.service.data.response;

import web.fram.side.article.domain.Article;

public record ArticleSearchServiceResponse(long id, String title, String author, String description) {

    public ArticleSearchServiceResponse(Article article) {
        this(article.getId(), article.getTitle(), article.getAuthor(), article.getDesc());
    }
}
