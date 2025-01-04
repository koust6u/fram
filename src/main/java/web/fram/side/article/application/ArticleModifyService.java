package web.fram.side.article.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.application.data.request.ArticleModifyAppRequest;
import web.fram.side.article.domain.repository.ArticleRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleModifyService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void modify(final ArticleModifyAppRequest request) {
    }
}
