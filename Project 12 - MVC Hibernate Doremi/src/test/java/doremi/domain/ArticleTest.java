package doremi.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class ArticleTest {

    private static Validator validator;

    @BeforeAll
    public static void setupContext() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testIdTitreCategorieOK() {
        // given: un Article avec un id positif, un titre et une catégorie valides
        Article a = new Article(1, "Titre de l'article", "Categorie de l'article");
        // when: on vérifie les contraintes de validation de l'Article
        // then: il n'y a pas d'erreur de validation
        Assertions.assertTrue(validator.validate(a).isEmpty());
    }

    @Test
    public void testIdNegatif() {
        // given: un Article avec un id négatif
        Article a = new Article(-1, "Nouvel album de Sparks cette année", "Sortie");
        // when: on vérifie les contraintes de validation de l'Article
        // then: il y a une erreur de validation
        Assertions.assertFalse(validator.validate(a).isEmpty());
    }

    @Test
    public void testIdZero() {
        // given: un Article avec un id nul, un titre et une catégorie valides
        Article a = new Article(0, "Nouvel album de Sparks cette année", "Sortie");
        // when: on vérifie les contraintes de validation de l'Article
        // then: il n'y a pas d'erreur de validation
        Assertions.assertTrue(validator.validate(a).isEmpty());
    }

    @Test
    public void testTitreVide() {
        // given: un Article avec un titre vide
        Article a = new Article(1, "", "Sortie");
        // when: on vérifie les contraintes de validation de l'Article
        // then: il y a une erreur de validation
        Assertions.assertFalse(validator.validate(a).isEmpty());
    }

    @Test
    public void testTitreNull() {
        // given: un Article avec un titre null
        Article a = new Article(1, null, "Sortie");
        // when: on vérifie les contraintes de validation de l'Article
        // then: il y a une erreur de validation
        Assertions.assertFalse(validator.validate(a).isEmpty());
    }

    @Test
    public void testCategorieNull() {
        // given: un Article avec une catégorie null
        Article a = new Article(1, "Nouvel album de Sparks cette année", null);
        // when: on vérifie les contraintes de validation de l'Article
        // then: il n'y a pas d'erreur de validation
        Assertions.assertTrue(validator.validate(a).isEmpty());
    }

}