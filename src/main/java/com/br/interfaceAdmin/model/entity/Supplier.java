package com.br.interfaceAdmin.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String corporativeName;

    @NotBlank
    @Column(nullable = false)
    private String salesRepresentative;

    @NotNull
    @OneToOne
    private Address address;

    @NotNull
    @OneToOne
    private PersonalData personalData;
}
