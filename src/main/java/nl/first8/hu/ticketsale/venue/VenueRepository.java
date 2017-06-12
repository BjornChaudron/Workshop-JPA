package nl.first8.hu.ticketsale.venue;

import nl.first8.hu.ticketsale.repetoire.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

    private final EntityManager entityManager;

    @Autowired
    public VenueRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Concert> findConcertById(Long concertId) {
        return Optional.ofNullable(entityManager.find(Concert.class, concertId));
    }

    public List<Concert> findByArtistName(String name) {
        try {
            return entityManager
                    .createQuery("SELECT c FROM Concert c WHERE c.artist.name =:name", Concert.class)
                    .setParameter("name", name)
                    .getResultList();

        } catch (NoResultException nre) {
            return Collections.emptyList();
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }

    public List<Concert> findByGenre(String genre) {
        try {
            return entityManager
                    .createQuery("SELECT c FROM Concert c WHERE c.artist.genre IN :genre", Concert.class)
                    .setParameter("genre", Genre.valueOf(genre.toUpperCase()))
                    .getResultList();
        } catch (NoResultException nre) {
            return Collections.emptyList();
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }

    public List<Concert> findByLocation(String location) {
        try {
            return entityManager
                    .createQuery("SELECT c FROM Concert c WHERE c.location = :location", Concert.class)
                    .setParameter("location", location.toLowerCase())
                    .getResultList();
        } catch (NoResultException nre) {
            return Collections.emptyList();
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }

    public List<Concert> findAll() {
        try {
            return entityManager.createQuery("SELECT c FROM Concert c", Concert.class).getResultList();
        } catch(NoResultException e) {
            return Collections.emptyList();
        }

    }






}
