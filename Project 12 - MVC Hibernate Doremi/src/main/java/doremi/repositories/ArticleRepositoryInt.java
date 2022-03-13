package doremi.repositories;

import doremi.domain.Article;
import java.util.List;

public interface ArticleRepositoryInt {
    List<Article> findAllArticles();
    Article findArticleById(int id);
    Article saveArticle(Article article);
}