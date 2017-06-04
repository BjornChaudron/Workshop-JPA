package nl.first8.hu.ticketsale.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;

/**
 * Author: Bjorn, created on 2-6-2017.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditTrail {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

}
