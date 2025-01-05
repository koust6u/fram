package web.fram.side.article.application.data.response;

import web.fram.side.article.domain.Article;

public record ArticleSearchServiceResponse(long id, String title, String author, String content) {

    public ArticleSearchServiceResponse(Article article) {
        this(article.getId(), article.getTitleAsString(), article.getAuthor(), article.getContentAsString());
    }
}
