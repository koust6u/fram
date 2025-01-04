package web.dummy;

import web.fram.side.article.application.data.request.ArticleCreateAppRequest;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.Content;
import web.fram.side.article.domain.Title;
import web.fram.side.article.handler.api.data.request.ArticleCreateWebRequest;
import web.fram.side.article.handler.api.data.request.ArticleModifyWebRequest;

public abstract class ArticleDummies {

    public static Article article() {
        return new Article(new Title("제목"), "작성자", new Content("내용은 10자이상이여야합니다."));
    }

    public static ArticleCreateWebRequest articleCreateWebRequest() {
        return new ArticleCreateWebRequest("작성자", "제목", "내용은10자이상이여야합니다.");
    }

    public static ArticleCreateAppRequest articleCreateServiceRequest() {
        return new ArticleCreateAppRequest("제목", "작성자", "내용은10자이상이여야합니다.");
    }

    public static ArticleModifyWebRequest articleModifyWebRequest() {
        return new ArticleModifyWebRequest("수정된 제목", "수정된 작성글 내용입니다.");
    }
}
