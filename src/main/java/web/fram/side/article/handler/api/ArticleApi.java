package web.fram.side.article.handler.api;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.application.ArticleCreateService;
import web.fram.side.article.application.ArticleDeleteService;
import web.fram.side.article.application.ArticleModifyService;
import web.fram.side.article.application.ArticleSearchService;
import web.fram.side.article.application.data.response.ArticleSearchServiceResponse;
import web.fram.side.article.handler.api.data.request.ArticleCreateWebRequest;
import web.fram.side.article.handler.api.data.request.ArticleModifyWebRequest;
import web.fram.side.article.handler.api.data.response.ArticleSearchWebResponse;
import web.fram.side.article.handler.api.docs.ArticleApiDocs;

@RestController
@RequiredArgsConstructor
public class ArticleApi implements ArticleApiDocs {

    private final ArticleCreateService articleCreateService;
    private final ArticleSearchService articleSearchService;
    private final ArticleModifyService articleModifyService;
    private final ArticleDeleteService articleDeleteService;

    @PostMapping("/article")
    public ResponseEntity<Void> createArticle(@Valid @RequestBody final ArticleCreateWebRequest request) {
        final long createId = articleCreateService.create(request.toAppRequest());

        return ResponseEntity.created(URI.create("/article/" + createId))
                .build();
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<ArticleSearchWebResponse> searchSingle(@PathVariable(name = "id") final long id) {
        final ArticleSearchServiceResponse serviceResponse = articleSearchService.searchSingle(id);

        return ResponseEntity.ok(new ArticleSearchWebResponse(serviceResponse));
    }

    @GetMapping("/article/page/{pageId}")
    public ResponseEntity<List<ArticleSearchWebResponse>> searchPage(@PathVariable(name = "pageId") final int pageId) {
        final List<ArticleSearchWebResponse> responses = articleSearchService.searchPaging(pageId)
                .stream()
                .map(ArticleSearchWebResponse::new)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @PatchMapping("/article/{id}")
    public ResponseEntity<Void> modify(@PathVariable(name = "id") final long id,
                                       @RequestBody final ArticleModifyWebRequest request) {
        articleModifyService.modify(request.toAppRequest(id));

        return ResponseEntity.noContent()
                .build();
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") final long id) {
        articleDeleteService.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
}
