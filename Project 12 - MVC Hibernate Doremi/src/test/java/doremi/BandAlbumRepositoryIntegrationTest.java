package doremi;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.domain.Genre;
import doremi.repositories.BandAlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
    }

    @Test
    public void testSaveValidAlbum() {

        // given: a valid Album

        // when: saving the album
        bandAlbumRepository.save(album);

        // then: the album is saved with a generated id
        assertThat(album.getId(), is(notNullValue()));
    }

    @Test
    public void testSaveValidBand() {

        // given: a valid Band

        // when: saving the band
        bandAlbumRepository.save(band);

        // then: the band is saved with a generated id
        assertThat(band.getId(), is(notNullValue()));
    }

    @Test
    public void testFindExistingAlbumById() {

        // given: a saved album
        bandAlbumRepository.save(album);

        // when: an existing album is searched by id
        Album fetchedAlbum = bandAlbumRepository.findAlbumById(album.getId());

        // then: the fetched album is correctly instanced
        assertThat(fetchedAlbum.getTitle(), is(album.getTitle()));
        assertThat(fetchedAlbum.getYear(), is(album.getYear()));

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
        bandAlbumRepository.save(band);

        // when: an existing  band is searched by id
        Band fetchedBand = bandAlbumRepository.findBandById(band.getId());

        // then: the fetched band is correctly instanced
        assertThat(fetchedBand.getName(), is(band.getName()));
        assertThat(fetchedBand.getActive(), is(band.getActive()));
    }

    @Test
    public void testFindNonExistingBandById() {

        // when: a non existing  band is searched by id
        Band fetchedBand = bandAlbumRepository.findBandById(Long.MAX_VALUE);

        // then: the fetched band is null
        assertThat(fetchedBand, is(nullValue()));

    }

}