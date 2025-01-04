package web.dummy;

import web.fram.side.article.handler.api.data.ArticleCreateWebRequest;
import web.fram.side.article.service.data.ArticleCreateServiceRequest;

public abstract class ArticleDummies {

    public static ArticleCreateWebRequest articleCreateWebRequest() {
        return new ArticleCreateWebRequest("작성자", "제목", "내용은10자이상이여합니다.");
    }

    public static ArticleCreateServiceRequest articleCreateServiceRequest() {
        return new ArticleCreateServiceRequest("제목", "작성자", "내용은10자이상이여합니다.");
    }
}
