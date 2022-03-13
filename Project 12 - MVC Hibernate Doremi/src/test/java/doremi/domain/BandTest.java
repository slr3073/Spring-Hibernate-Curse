package doremi.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class BandTest {

    private static Validator validator;

    @BeforeAll
    public static void setupContext() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testBandAvecNomValideOK() {
        // given: un Band avec un nom et un booléen
        Band b = new Band("The Strokes", true);
        // when: on vérifie les contraintes de validation du Band
        // then: il n'y a pas d'erreur de validation
        Assertions.assertTrue(validator.validate(b).isEmpty());
    }

    @Test
    public void testBandAvecNomNullNOK() {
        // given: un Band avec un nom null
        Band b = new Band(null, true);
        // when: on vérifie les contraintes de validation du Band
        // then: il y a une erreur de validation
        Assertions.assertFalse(validator.validate(b).isEmpty());
    }

    @Test
    public void testBandAvecNomVideNOK() {
        // given: un Band avec un nom vide
        Band b = new Band("", true);
        // when: on vérifie les contraintes de validation du Band
        // then: il y a une erreur de validation
        Assertions.assertFalse(validator.validate(b).isEmpty());
    }

    @Test
    public void testUnNouveauBandNAPasDAlbum() {
        // given: un Band avec un nom et un booléen
        Band b = new Band("The Strokes", true);
        // then: ce Band n'a pas d'album
        Assertions.assertEquals(0, b.getAlbums().size(), "Un nouveau groupe Band doit avoir une liste d'album vide");
    }

    @Test
    public void testAddAlbumLieBienLesEntites() {
        // given: un Band b
        Band b = new Band("The Strokes", true);
        Album a = new Album("Is This It", Genre.INDIE, 2001);
        // when: l'Album a est associé au groupe Band b
        b.addAlbum(a);
        // then: le Band b a un album associé
        Assertions.assertEquals(1, b.getAlbums().size());
        Assertions.assertTrue(b.getAlbums().contains(a));
        Assertions.assertEquals(b, a.getBand());
    }

    @Test
    public void testRemoveAlbumSupprimeBienLeLienEntreLesEntites() {
        // given: un Band b
        Band b = new Band("The Strokes", true);
        // given: un Album a associé au Band b
        Album a = new Album("Is This It", Genre.INDIE, 2001);
        // when: l'Album a est associé au groupe Band b
        b.addAlbum(a);
        // when: l'Album a est supprimé des albums du Band b
        b.removeAlbum(a);
        // then: le Band b n'a plus d'album associé
        Assertions.assertEquals(0, b.getAlbums().size());
        // then: le Band b n'est plus associé à l'album a
        Assertions.assertFalse(b.getAlbums().contains(a));
        Assertions.assertNull(a.getBand());
    }


}