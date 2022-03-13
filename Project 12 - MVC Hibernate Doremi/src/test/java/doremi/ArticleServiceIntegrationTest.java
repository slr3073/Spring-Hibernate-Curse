package doremi;

import doremi.repositories.ArticleRepositoryInt;
import doremi.repositories.ArticleRepositoryWithJdbc;
import doremi.services.ArticleService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ArticleServiceIntegrationTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testTypeRepository() {
        // le dépôt associé au service est de type ArticleRepositoryWithJdbc
        assertThat(articleService.getArticleRepository(), instanceOf(ArticleRepositoryWithJdbc.class));
        // le dépôt associé au service est de type ArticleRepositoryInt
        assertThat(articleService.getArticleRepository(), instanceOf(ArticleRepositoryInt.class));
    }

    @Test
    public void testFindAllCardinal() {
        // when: une requête pour obtenir tous les articles en base est émise
        // then: une liste de 9 éléments est reçu en réponse
        Assertions.assertEquals(9, (articleService.findAllArticles().size()), "the batch provides 9 articles");
    }

    @Test
    public void testFindAllPremiereCategorie() {
        // when: une requête pour obtenir le premier article en base est émise
        // then: la réponse est un article de la catégorie "Concert"
        Assertions.assertEquals("Concert", (articleService.findAllArticles().get(0).getCategory()));
    }

    @Test
    public void testFindByIdOk() {
        // when: une requête pour obtenir l'article avec l'id 0 est émise
        // then: la réponse est un article dont l'id est 0
        Assertions.assertEquals(0, (articleService.findArticleById(0)).getArticleId());
    }

    @Test
    public void testFindByIdInconnuIsNull() {
        // when: une requête pour obtenir un article avec un id inexistant en base est émise
        // then: la réponse est null
        Assertions.assertNull(articleService.findArticleById(9999));
    }

}