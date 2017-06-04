package nl.first8.hu.ticketsale.repetoire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: Bjorn, created on 23-5-2017.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Artist(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

}
