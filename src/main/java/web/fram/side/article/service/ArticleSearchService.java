package web.fram.side.article.service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.repository.ArticleRepository;
import web.fram.side.article.service.data.response.ArticleSearchServiceResponse;

@Service
@RequiredArgsConstructor
public class ArticleSearchService {

    private static final int PAGE_SIZE = 10;

    private final ArticleRepository articleRepository;

    public ArticleSearchServiceResponse searchSingle(final long id) {
        final Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("%d는 존재하지 않는 글 ID입니다.".formatted(id)));
        return new ArticleSearchServiceResponse(article);
    }

    public List<ArticleSearchServiceResponse> searchPaging(final int pageNumber) {
        final PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE);
        return articleRepository.findAll(pageRequest)
                .map(ArticleSearchServiceResponse::new)
                .toList();
    }
}
