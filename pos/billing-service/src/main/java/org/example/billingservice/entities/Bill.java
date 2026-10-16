package org.example.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.billingservice.model.Customer;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
@Entity
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue
    private Long id;
    private Date billingDate;
    private long customerId;
    @OneToMany( mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
