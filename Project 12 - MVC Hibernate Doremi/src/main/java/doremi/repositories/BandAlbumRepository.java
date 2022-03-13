package doremi.repositories;

import doremi.domain.Album;
import doremi.domain.Band;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Getter
@Setter
@Transactional
@Repository
public class BandAlbumRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Album save(Album album) {
        Band savedBand = save(album.getBand());
        album.setBand(savedBand);
        Album savedAlbum = entityManager.merge(album);
        savedBand.addAlbum(savedAlbum);
        return savedAlbum;
    }

    public Band save(Band band) {
        return entityManager.merge(band);
    }

    public Album findAlbumById(Long id) {
        return entityManager.find(Album.class, id);
    }

    public Band findBandById(Long id) {
        return entityManager.find(Band.class, id);
    }

    public List<Band> findAllBand() {
        TypedQuery<Band> query = entityManager.createQuery("select b from Band b order by b.name", Band.class);
        return query.getResultList();
    }
}
