package web.fram.side.article.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.fram.side.article.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
