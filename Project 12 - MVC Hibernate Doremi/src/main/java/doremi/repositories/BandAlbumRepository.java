package doremi.repositories;

import doremi.domain.Album;
import doremi.domain.Band;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;


@Getter
@Setter
@Repository
public class BandAlbumRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Album album) {
        entityManager.persist(album);
    }

    public void save(Band band) {
        entityManager.persist(band);
    }

    public Album findAlbumById(Long id) {
        return entityManager.find(Album.class, id);
    }

    public Band findBandById(Long id) {
        return entityManager.find(Band.class, id);
    }
}
