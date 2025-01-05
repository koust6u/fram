package web.fram.side.article.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import web.fram.side.article.domain.repository.ArticleRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleDeleteService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void delete(final long id) {
        articleRepository.deleteById(id);
    }
}
