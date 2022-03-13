package doremi;

import doremi.repositories.ArticleRepositoryInt;
import doremi.services.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class ArticleServiceTest {

    private ArticleService articleService;

    @MockBean
    private ArticleRepositoryInt articleRepository;

    @BeforeEach
    public void setup() {
        articleService = new ArticleService();
        articleService.setArticleRepository(articleRepository);
    }

    @Test
    public void testFindAllArticlesIsDelegatedToRepository() {
        // when: findAllArticles() est appelé sur un articleService
        articleService.findAllArticles();
        // then: findAllArticles() du dépôt associé au service est invoqué
        verify(articleService.getArticleRepository()).findAllArticles();
    }

}