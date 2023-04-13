package com.br.interfaceAdmin.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Length(min = 5, max = 100)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Length(min = 5, max = 225)
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private double price;

    //TODO aprimorar lógica para controle de estoque
//    @NotNull
//    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Stock stock;
}
