package doremi;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.repositories.BandAlbumRepository;
import doremi.services.BandAlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class BandAlbumServiceTest {

    private BandAlbumService bandAlbumService;

    @MockBean
    private Band band;

    @MockBean
    private Album album;

    @MockBean
    private BandAlbumRepository bandAlbumRepository;

    private Long anId = 1L;


    @BeforeEach
    public void setup() {
        bandAlbumService = new BandAlbumService();
        bandAlbumService.setBandAlbumRepository(bandAlbumRepository);
    }

    @Test
    public void testSaveBandIsDelegatedToRepository() {
        // when: save() est appelé sur un objet Band
        bandAlbumService.save(band);
        // then: save() du dépôt associé au service est invoqué
        verify(bandAlbumService.getBandAlbumRepository()).save(band);
    }

    @Test
    public void testSaveAlbumIsDelegatedToRepository() {
        // when: save() est appelé sur un objet Band
        bandAlbumService.save(band);
        // then: save() du dépôt associé au service est invoqué
        verify(bandAlbumService.getBandAlbumRepository()).save(band);
    }

    @Test
    public void testFindBandByIdIsDelegatedToRepository() {
        // when: findBandById() est appelé
        bandAlbumService.findBandById(anId);
        // then: findBandById() du dépôt associé au service est invoqué
        verify(bandAlbumService.getBandAlbumRepository()).findBandById(anId);
    }

    @Test
    public void testFindAlbumByIdIsDelegatedToRepository() {
        // when: findAlbumById() est appelé
        bandAlbumService.findAlbumById(anId);
        // then: findAlbumById() du dépôt associé au service est invoqué
        verify(bandAlbumService.getBandAlbumRepository()).findAlbumById(anId);
    }

}