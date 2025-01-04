package web.fram.side.article.handler.api.data.request;

import jakarta.validation.constraints.NotBlank;

import web.fram.side.article.application.data.request.ArticleModifyAppRequest;

public record ArticleModifyWebRequest(@NotBlank(message = "제목은 비워둘 수 없음.") String title,
                                      @NotBlank(message = "내용은 비워둘 수 없음.") String content) {

    public ArticleModifyAppRequest toAppRequest(final long targetId) {
        return new ArticleModifyAppRequest(targetId, title, content);
    }
}
