package com.br.interfaceAdmin.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(nullable = false)
    private long quantity;

    @NotNull
    @Pattern(regexp = "PENDING|PROGRESSING|AUTHORIZED|CONCLUDED|DELIVERED")
    @Column(nullable = false)
    private Status status;

    @NotNull
    @ManyToOne
    private Customer customer;

    @NotNull
    @ManyToOne
    private Supplier supplier;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "produto", nullable = false)
    private Product product;
}
