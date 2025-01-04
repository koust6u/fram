package web.fram.side.article.domain.service;

import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.Content;
import web.fram.side.article.domain.Title;

public class ArticleCreator {

    private final Title title;
    private final String author;
    private final Content content;

    public ArticleCreator(final String title, final String author, final String content) {
        this.title = new Title(title);
        this.author = author;
        this.content = new Content(content);
    }

    public Article toEntity() {
        return new Article(title, author, content);
    }
}
