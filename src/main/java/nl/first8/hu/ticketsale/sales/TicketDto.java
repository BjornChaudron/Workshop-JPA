package nl.first8.hu.ticketsale.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.registration.Account;
import nl.first8.hu.ticketsale.repetoire.Artist;
import nl.first8.hu.ticketsale.repetoire.Genre;
import nl.first8.hu.ticketsale.venue.Location;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Artist artist;

    private Genre genre;

    private String location;

}
