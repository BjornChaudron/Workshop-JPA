package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bjorn, created on 4-6-2017.
 */
@RestController
@RequestMapping("/concerts")
@Transactional
public class VenueResource {

    private final VenueService service;

    @Autowired
    public VenueResource(VenueService service) { this.service = service; }

    @GetMapping(path = "/artist/{name}")
    public List<Concert> getByArtistName(@PathVariable("name") final String name) {
        return service.getByArtistName(name);
    }

    @GetMapping(path = "/genre/{genre}")
    public List<Concert> getByGenre(@PathVariable("genre") final String genre) {
        return service.getByGenre(genre);
    }

    @GetMapping(path = "/location/{location}")
    public List<Concert> getByLocation(@PathVariable("location") final String location) {
        return service.getByLocation(location);
    }

    @GetMapping(path = "/all")
    public List<Concert> getAll() {
        return service.list();
    }

}
