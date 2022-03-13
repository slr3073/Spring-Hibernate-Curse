package doremi.services;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.repositories.BandAlbumRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class BandAlbumService {
    @Autowired
    private BandAlbumRepository bandAlbumRepository;

    public void save(Album album) {
        bandAlbumRepository.save(album);
    }

    public void save(Band band) {
        bandAlbumRepository.save(band);
    }

    public Album findAlbumById(Long id) {
        return bandAlbumRepository.findAlbumById(id);
    }

    public Band findBandById(Long id) {
        return bandAlbumRepository.findBandById(id);
    }
}
