package web.fram.side.article.handler.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleUi {

    @GetMapping("/articles")
    public String getArticles() {
        return "article/articles";
    }

    @GetMapping("/article-form")
    public String getArticleCreateForm() {
        return "article/create";
    }
}
