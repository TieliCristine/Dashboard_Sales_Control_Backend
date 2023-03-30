package com.br.interfaceAdmin.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String description;


    //TODO aprimorar lógica para controle de estoque
//    @NotNull
//    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Stock stock;
}
