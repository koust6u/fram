package web.fram.side.article.domain.service;

import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.Content;
import web.fram.side.article.domain.Title;

public class ArticleModifier {

    private final Content content;
    private final Title title;

    public ArticleModifier(final String content, final String title) {
        this.content = new Content(content);
        this.title = new Title(title);
    }

    public void modify(Article article) {
        article.changeTitle(title);
        article.changeContent(content);
    }
}
