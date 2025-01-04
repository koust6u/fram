package web.fram.side.article.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.application.data.request.ArticleCreateAppRequest;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.repository.ArticleRepository;
import web.fram.side.article.domain.service.ArticleCreator;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleCreateService {

    private final ArticleRepository articleRepository;

    @Transactional
    public long create(final ArticleCreateAppRequest request) {
        final ArticleCreator create = new ArticleCreator(request.title(), request.author(), request.content());
        final Article entity = articleRepository.save(create.toEntity());
        return entity.getId();
    }
}
