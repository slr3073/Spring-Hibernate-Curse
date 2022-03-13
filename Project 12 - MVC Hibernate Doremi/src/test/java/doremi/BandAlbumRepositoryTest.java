package doremi;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.repositories.BandAlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class BandAlbumRepositoryTest {

    private BandAlbumRepository bandAlbumRepository;

    @MockBean
    private EntityManager entityManager;

    @MockBean(name = "band")
    private Band band;

    @MockBean(name = "managedBand")
    private Band managedBand;

    @MockBean(name = "album")
    private Album album;

    @MockBean(name = "managedAlbum")
    private Album managedAlbum;

    private final Long anId = 1L;

    @BeforeEach
    public void setUp() {
        bandAlbumRepository = new BandAlbumRepository();
        bandAlbumRepository.setEntityManager(entityManager);
        given(this.entityManager.merge(album)).willReturn(managedAlbum);
        given(this.entityManager.merge(band)).willReturn(managedBand);
        given(this.album.getBand()).willReturn(band);
        given(this.managedAlbum.getBand()).willReturn(band);
    }

    @Test
    public void testTheEntityManagerMergesAlbumWhenAnAlbumIsSaved() {

        // when: trying to save a Album
        bandAlbumRepository.save(album);

        // then: the merge method is invoked on the entity manager
        verify(bandAlbumRepository.getEntityManager()).merge(album);
    }

    @Test
    public void testSaveAlbumReturnsAnAlbum() {
        assertInstanceOf(Album.class, bandAlbumRepository.save(album));
    }

    @Test
    public void testTheEntityManagerMergesABandWhenABandIsSaved() {

        // when: trying to save a Band
        bandAlbumRepository.save(band);

        // then: the persist method is invoked on the entity manager
        verify(bandAlbumRepository.getEntityManager()).merge(band);
    }

    @Test
    public void testSaveBandReturnsABand() {
        assertInstanceOf(Band.class, bandAlbumRepository.save(band));
    }

    @Test
    public void testTheEntityManagerFindAlbumWhenAlbumIsSearchedById() {

        // when: trying to find an Album
        bandAlbumRepository.findAlbumById(anId);

        // then: the find method is invoked on the entity manager
        verify(bandAlbumRepository.getEntityManager()).find(Album.class, anId);
    }

    @Test
    public void testTheEntityManagerFindBandWhenBandIsSearchedById() {

        // when: trying to find a Band
        bandAlbumRepository.findBandById(anId);

        // then: the find method is invoked on the entity manager
        verify(bandAlbumRepository.getEntityManager()).find(Band.class, anId);
    }
}