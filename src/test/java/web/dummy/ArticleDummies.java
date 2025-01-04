package web.dummy;

import web.fram.side.article.domain.Article;
import web.fram.side.article.handler.api.data.request.ArticleCreateWebRequest;
import web.fram.side.article.service.data.request.ArticleCreateServiceRequest;

public abstract class ArticleDummies {

    public static Article article() {
        return new Article("제목", "작성자", "내용은 10자이상이여야합니다.");
    }

    public static ArticleCreateWebRequest articleCreateWebRequest() {
        return new ArticleCreateWebRequest("작성자", "제목", "내용은10자이상이여야합니다.");
    }

    public static ArticleCreateServiceRequest articleCreateServiceRequest() {
        return new ArticleCreateServiceRequest("제목", "작성자", "내용은10자이상이여야합니다.");
    }
}
