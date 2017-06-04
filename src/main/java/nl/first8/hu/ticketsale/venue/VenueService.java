package nl.first8.hu.ticketsale.venue;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: Bjorn, created on 4-6-2017.
 */
@Service
public class VenueService {

    private final VenueRepository repository;

    @Autowired
    public VenueService(VenueRepository repository) { this.repository = repository; }


    public List<Concert> getByArtistName(@NonNull final String name) {
        return repository.findByArtistName(name);
    }

    public List<Concert> getByGenre(@NonNull final String genre) {
        return repository.findByGenre(genre);
    }

    public List<Concert> getByLocation(@NonNull final String location) {
        return repository.findByLocation(location);
    }

    public List<Concert> list() {
        return repository.findAll();
    }
}
