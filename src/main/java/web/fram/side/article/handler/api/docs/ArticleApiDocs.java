package web.fram.side.article.handler.api.docs;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import web.fram.side.article.handler.api.data.ArticleCreateWebRequest;

@Tag(name = "작성글 API")
public interface ArticleApiDocs {

    @Operation(summary = "작성글 생성")
    @ApiResponse(responseCode = "201 CREATED", description = "작성글 생성 OK")
    ResponseEntity<Void> createArticle(ArticleCreateWebRequest request);
}
