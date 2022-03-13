package doremi;

import doremi.domain.Article;
import doremi.repositories.ArticleRepositoryInt;
import doremi.repositories.ArticleRepositoryWithJdbc;
import doremi.services.ArticleService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Transactional
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

    @Test
    public void testSaveNullEntailsException() {
        // when: une requête pour sauver un Article null en base est émise (manuellement)
        // then: une exception est levée
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> { articleService.saveArticle(null); });
    }

    @Test
    public void testSaveDejaPresentEntailsException() {
        // when: une requête pour sauver un Article déjà en base est émise
        // then: une exception est levée (manuellement)
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> { articleService.saveArticle(new Article(1, "titre", "categorie")); });
    }

    @Test  @DirtiesContext
    public void testSaveIsSaved() {
        // when: une requête pour sauver un article en base est émise
        Article a = new Article (125, "Titre", "Categorie");
        // when: l'Article n'est pas présent en base
        Assertions.assertNull(articleService.findArticleById(a.getArticleId()));
        // then: l'Article est sauvé en base et retourné par la méthode save
        Assertions.assertEquals(a, articleService.saveArticle(a));
    }

    @Test  @DirtiesContext
    public void testSaveIsSavedCardinal() {
        // given : la taille de la base
        int before = (articleService.findAllArticles()).size();

        // when: une requête pour sauver un article en base est émise
        Article a = new Article (130, "Titre", "Categorie");
        articleService.saveArticle(a);

        // when: la taille de la base est récupérée après l'insertion
        int after = (articleService.findAllArticles()).size();

        // then: le nombre d'entrées en base a augmenté de 1
        Assertions.assertEquals(before + 1, after);
    }

    @Test  @DirtiesContext
    public void testArticleRecupereeInchangee() {
        // when: une requête pour sauver un article en base est émise
        Article a = new Article (135, "Titre", "Categorie");
        articleService.saveArticle(a);

        // then: l'état de l'Article reste inchangé par la sauvegarde en base
        Article fetched = articleService.findArticleById(a.getArticleId());
        Assertions.assertEquals(fetched.getArticleId(), a.getArticleId());
        Assertions.assertEquals(fetched.getTitle(), a.getTitle());
        Assertions.assertEquals(fetched.getCategory(), a.getCategory());
    }

}