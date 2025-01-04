package web.fram.side.article.handler.api.data.request;

import jakarta.validation.constraints.NotBlank;

import web.fram.side.article.service.data.request.ArticleCreateServiceRequest;

public record ArticleCreateWebRequest(@NotBlank(message = "작성자는 비워둘 수 없음.") String author,
                                      @NotBlank(message = "제목은 비워둘 수 없음.") String title,
                                      @NotBlank(message = "내용은 비워둘 수 없음.") String desc) {

    public ArticleCreateServiceRequest toServiceRequest() {
        return new ArticleCreateServiceRequest(title, author, desc);
    }
}
