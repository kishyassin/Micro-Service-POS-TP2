package org.example.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.billingservice.model.Product;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id @GeneratedValue
    private Long id;
    private int quantity;
    private long productId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Bill bill;

    @Transient
    private Product product;
}
