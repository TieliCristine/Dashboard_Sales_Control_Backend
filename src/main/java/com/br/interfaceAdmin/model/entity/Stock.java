package com.br.interfaceAdmin.model.entity;

//TODO aprimorar lógica para controle de estoque

//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "Stock")
//public class Stock {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @NotNull
//    @Column(nullable = false)
//    private long quantity;
//
//    @NotBlank
//    @Column(nullable = false)
//    private String location;
//
//    @OneToOne
//    @JoinColumn(name = "product_id", nullable = false, unique = true)
//    private Product product;
//}
