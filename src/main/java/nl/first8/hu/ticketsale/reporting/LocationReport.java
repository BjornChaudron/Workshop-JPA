package nl.first8.hu.ticketsale.reporting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.repetoire.Artist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationReport implements Serializable {

    @OneToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;
    private String concertLocations;
    private String ticketCity;
}
