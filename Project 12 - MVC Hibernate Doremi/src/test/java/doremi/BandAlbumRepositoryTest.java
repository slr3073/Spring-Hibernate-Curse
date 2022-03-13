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

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class BandAlbumRepositoryTest {

    private BandAlbumRepository bandAlbumRepository;

    @MockBean
    private EntityManager entityManager;

    @MockBean
    private Band band;

    @MockBean
    private Album album;

    private Long anId = 1L;

    @BeforeEach
    public void setUp() throws Exception {
        bandAlbumRepository = new BandAlbumRepository();
        bandAlbumRepository.setEntityManager(entityManager);
    }

    @Test
    public void testTheEntityManagerPersistsAlbumWhenAnAlbumIsSaved() {

        // when: trying to save a Album
        bandAlbumRepository.save(album);

        // then: the persist method is invoked on the entity manager
        verify(bandAlbumRepository.getEntityManager()).persist(album);
    }

    @Test
    public void testTheEntityManagerPersistsABandWhenABandIsSaved() {

        // when: trying to save a Band
        bandAlbumRepository.save(band);

        // then: the persist method is invoked on the entity manager
        verify(bandAlbumRepository.getEntityManager()).persist(band);
    }

    @Test
    public void testTheEntityManagerFindAlbumWhenAlbumIsSearchedById() {

        // when: trying to find an Album
        bandAlbumRepository.findAlbumById(anId);

        // then: the find method is invoked on the entity manager
        verify(entityManager).find(Album.class, anId);
    }

    @Test
    public void testTheEntityManagerFindBandWhenBandIsSearchedById() {

        // when: trying to find a Band
        bandAlbumRepository.findBandById(anId);

        // then: the find method is invoked on the entity manager
        verify(entityManager).find(Band.class, anId);
    }
}