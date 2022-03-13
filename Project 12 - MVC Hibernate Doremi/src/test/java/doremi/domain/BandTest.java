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

}