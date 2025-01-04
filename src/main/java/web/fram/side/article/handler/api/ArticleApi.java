package web.fram.side.article.handler.api;

import java.net.URI;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.handler.api.data.ArticleCreateWebRequest;
import web.fram.side.article.service.ArticleCreateService;

@RestController
@RequiredArgsConstructor
public class ArticleApi {

    private final ArticleCreateService articleCreateService;

    @PostMapping("/article")
    public ResponseEntity<Void> createArticle(@Valid @RequestBody final ArticleCreateWebRequest request) {
        final long createId = articleCreateService.create(request.toServiceRequest());

        return ResponseEntity.created(URI.create("/article/" + createId))
                .build();
    }
}
