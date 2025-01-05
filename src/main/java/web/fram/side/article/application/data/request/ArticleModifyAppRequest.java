package web.fram.side.article.application.data.request;

public record ArticleModifyAppRequest(long targetId, String title, String content) {
}
