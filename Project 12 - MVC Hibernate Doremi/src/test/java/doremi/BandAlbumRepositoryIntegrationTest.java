package doremi;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.domain.Genre;
import doremi.repositories.BandAlbumRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class BandAlbumRepositoryIntegrationTest {

    @Autowired
    private BandAlbumRepository bandAlbumRepository;

    private Album album;
    private Band band;

    @BeforeEach
    public void setUp() {
        // given: a transient and valid instance of Album
        album = new Album("Exodus", Genre.REGGAE, 1977);
        // given: a transient and valid instance of Band
        band = new Band("Bob Marley and the Wailers", false);
        album.setBand(band);
    }

    @Test
    public void testSaveValidAlbum() {

        // given: a transient and valid Album

        //then: the Album has no id
        assertThat(album.getId(), is(nullValue()));

        // when: saving the album
        Album managedAlbum = bandAlbumRepository.save(album);

        // then: the returned album is saved with a generated id
        assertThat(managedAlbum.getId(), is(notNullValue()));

        // then: the associated band is saved too
        assertThat(managedAlbum.getBand().getId(), is(notNullValue()));

        // then: the band has the album referenced in its collection of album
        assertThat(managedAlbum.getBand().getAlbums(), hasItem(managedAlbum));
    }

    @Test
    public void testSaveValidBand() {

        // given: a valid Band

        //then: the Band has no id
        assertThat(band.getId(), is(nullValue()));

        // when: saving the band
        Band savedBand = bandAlbumRepository.save(band);

        // then: the band is saved with a generated id
        assertThat(savedBand.getId(), is(notNullValue()));
    }

    @Test
    public void testFindExistingAlbumById() {

        // given: a saved album
        Album savedAlbum = bandAlbumRepository.save(album);

        // when: an existing album is searched by id
        Album fetchedAlbum = bandAlbumRepository.findAlbumById(savedAlbum.getId());

        // then: the fetched album is correctly instanced
        assertThat(fetchedAlbum.getTitle(), is(savedAlbum.getTitle()));
        assertThat(fetchedAlbum.getYear(), is(savedAlbum.getYear()));

    }

    @Test
    public void testFindNonExistingAlbumById() {

        // when: a non existing  album is searched by id
        Album fetchedAlbum = bandAlbumRepository.findAlbumById(Long.MAX_VALUE);

        // then: the fetched album is null
        assertThat(fetchedAlbum, is(nullValue()));

    }

    @Test
    public void testFindExistingBand() {

        // given: a saved band
        Band savedBand = bandAlbumRepository.save(band);

        // when: an existing  band is searched by id
        Band fetchedBand = bandAlbumRepository.findBandById(savedBand.getId());

        // then: the fetched band is correctly instanced
        assertThat(fetchedBand.getName(), is(savedBand.getName()));
        assertThat(fetchedBand.getActive(), is(savedBand.getActive()));
    }

    @Test
    public void testFindNonExistingBandById() {

        // when: a non existing  band is searched by id
        Band fetchedBand = bandAlbumRepository.findBandById(Long.MAX_VALUE);

        // then: the fetched band is null
        assertThat(fetchedBand, is(nullValue()));

    }

    @Test
    public void testUpdatedAlbumIsUpdated() {
        // given: un Album persisté
        Album albumSaved = bandAlbumRepository.save(album);

        Album fetched = bandAlbumRepository.findAlbumById(albumSaved.getId());
        // when: le genre est modifié au niveau "objet"
        fetched.setGenre(Genre.FOLK);
        // when: la mise à jour est envoyée en base
        Album fetchedSaved = bandAlbumRepository.save(fetched);
        // when: l'album est relu en base
        Album fetchedUpdated = bandAlbumRepository.findAlbumById(albumSaved.getId());
        // then: le genre a bien été mis à jour
        assertEquals(fetchedSaved.getGenre(), fetchedUpdated.getGenre());
    }

    protected Long countAlbum() {
        return (Long) bandAlbumRepository.getEntityManager().createQuery("SELECT COUNT(p) FROM Album p").getSingleResult();
    }

    @Test
    public void testUpdateDoesNotCreateANewEntry() {
        // given: un Album persisté
        Album savedAlbum = bandAlbumRepository.save(album);

        Long count = countAlbum();
        Album fetched = bandAlbumRepository.findAlbumById(savedAlbum.getId());

        // when: le genre est modifié au niveau "objet"
        fetched.setGenre(Genre.FOLK);
        // when: la mise à jour est répercuté en base
        bandAlbumRepository.save(fetched);
        // then: une nouvelle entrée n'a pas été créée en base
        assertEquals(count, countAlbum());
    }

    @Test
    public void testAnAlbumIsOnlyAddedOnceToTheBand() {
        // given: le nombre countBandAlbum d'albums d'un groupe
        long countBandAlbum = band.getAlbums().size();
        // when: un nouvel album du groupe est sauvé en base
        Album albumSaved = bandAlbumRepository.save(album);
        // then: le nombre d'albums du groupe a augmenté de 1
        assertEquals(countBandAlbum + 1, albumSaved.getBand().getAlbums().size());
        // when: l'album est à nouveau sauvé
        albumSaved = bandAlbumRepository.save(albumSaved);
        // then: le nombre d'albums du groupe n'a pas changé
        assertEquals(countBandAlbum + 1, albumSaved.getBand().getAlbums().size());
    }
}