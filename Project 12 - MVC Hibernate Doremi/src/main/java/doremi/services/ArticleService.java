package doremi.services;

import doremi.domain.Article;
import doremi.repositories.ArticleRepositoryInt;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class ArticleService {
    @Autowired
    private ArticleRepositoryInt articleRepository;

    public List<Article> findAllArticles() {
        return articleRepository.findAllArticles();
    }

    public Article findArticleById(int id){
        return articleRepository.findArticleById(id);
    }

    public Article saveArticle(Article article) throws InvalidDataAccessApiUsageException {
        return this.articleRepository.saveArticle(article);
    }
}
