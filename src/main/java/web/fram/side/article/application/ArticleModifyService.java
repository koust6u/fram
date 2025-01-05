package web.fram.side.article.application;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.application.data.request.ArticleModifyAppRequest;
import web.fram.side.article.domain.Article;
import web.fram.side.article.domain.repository.ArticleRepository;
import web.fram.side.article.domain.service.ArticleModifier;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleModifyService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void modify(final ArticleModifyAppRequest request) {
        final ArticleModifier modifier = new ArticleModifier(request.content(), request.title());
        final Article article = articleRepository.findById(request.targetId())
                .orElseThrow(() -> new EntityNotFoundException("%d는 존재하지 않는 작성글 ID입니다.".formatted(request.targetId())));
        modifier.modify(article);
    }
}
