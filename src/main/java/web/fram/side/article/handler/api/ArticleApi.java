package web.fram.side.article.handler.api;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.handler.api.data.request.ArticleCreateWebRequest;
import web.fram.side.article.handler.api.data.response.ArticleSearchWebResponse;
import web.fram.side.article.handler.api.docs.ArticleApiDocs;
import web.fram.side.article.service.ArticleCreateService;
import web.fram.side.article.service.ArticleSearchService;
import web.fram.side.article.service.data.response.ArticleSearchServiceResponse;

@RestController
@RequiredArgsConstructor
public class ArticleApi implements ArticleApiDocs {

    private final ArticleCreateService articleCreateService;
    private final ArticleSearchService articleSearchService;

    @PostMapping("/article")
    public ResponseEntity<Void> createArticle(@Valid @RequestBody final ArticleCreateWebRequest request) {
        final long createId = articleCreateService.create(request.toServiceRequest());

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
}
