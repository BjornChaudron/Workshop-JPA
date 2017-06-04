package nl.first8.hu.ticketsale.repetoire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bjorn, created on 1-6-2017.
 */
@Repository
public class ArtistRepository {

    private final EntityManager entityManager;

    @Autowired
    public ArtistRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public void insert(Artist artist) { entityManager.persist(artist); }

    public Artist update(Artist artist) { return entityManager.merge(artist); }

    public Optional<Artist> findById(final Long id) {
        return Optional.ofNullable(entityManager.find(Artist.class, id));
    }

    public List<Artist> findAll() {
        return entityManager.createQuery("SELECT a from Artist a", Artist.class).getResultList();
    }

}
