package web.fram.side.article.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.ArticleCreate;
import web.fram.side.article.domain.repository.ArticleRepository;
import web.fram.side.article.service.data.ArticleCreateServiceRequest;

@Service
@RequiredArgsConstructor
public class ArticleCreateService {

    private final ArticleRepository articleRepository;

    public long create(final ArticleCreateServiceRequest request) {
        final ArticleCreate create = new ArticleCreate(request.title(), request.author(), request.decs());
        final Article entity = articleRepository.save(create.toEntity());
        return entity.getId();
    }
}
