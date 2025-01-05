package web.fram.side.article.handler.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/article/edit")
    public String getArticleModifyForm(@RequestParam(name = "id") final Long id) {
        return "article/modify";
    }

    @GetMapping("/article/view")
    public String getArticle(@RequestParam(name = "id") final Long id) {
        return "article/article";
    }
}
