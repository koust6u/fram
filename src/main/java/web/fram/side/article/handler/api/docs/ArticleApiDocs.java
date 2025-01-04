package web.fram.side.article.handler.api.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import web.fram.side.article.handler.api.data.request.ArticleCreateWebRequest;
import web.fram.side.article.handler.api.data.request.ArticleModifyWebRequest;
import web.fram.side.article.handler.api.data.response.ArticleSearchWebResponse;

@Tag(name = "작성글 API")
public interface ArticleApiDocs {

    @Operation(summary = "작성글 생성")
    @ApiResponse(responseCode = "201 CREATED", description = "작성글 생성 성공")
    ResponseEntity<Void> createArticle(ArticleCreateWebRequest request);

    @Operation(summary = "작성글 단건 조회")
    @ApiResponse(responseCode = "200 OK", description = "작성글 단건조회 성공")
    ResponseEntity<ArticleSearchWebResponse> searchSingle(long id);

    @Operation(summary = "작성글 페이징 조회")
    @ApiResponse(responseCode = "200 OK", description = "작성글 페이징조회 성공")
    ResponseEntity<List<ArticleSearchWebResponse>> searchPage(int pageId);

    @Operation(summary = "작성글 수정")
    @ApiResponse(responseCode = "204 NO CONTENT", description = "작성글 수정 성공")
    ResponseEntity<Void> modify(long id, ArticleModifyWebRequest request);
}
