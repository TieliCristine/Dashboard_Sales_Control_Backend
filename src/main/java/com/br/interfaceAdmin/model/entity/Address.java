package com.br.interfaceAdmin.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String street;
    @NotBlank
    private int number;
    private String supplemental;
    @NotBlank
    private String district;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
}
