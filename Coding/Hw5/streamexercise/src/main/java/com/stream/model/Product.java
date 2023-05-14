package com.stream.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    @With
    private Double price;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    private Set<Order> orders;
}
