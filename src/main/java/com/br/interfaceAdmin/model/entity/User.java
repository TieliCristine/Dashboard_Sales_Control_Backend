package com.br.interfaceAdmin.model.entity;

import com.br.interfaceAdmin.enumeration.AccessLvl;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Date birthdate;

    @NotBlank
    @Column(nullable = false)
    private String jobPosition;

    @NotNull
    @Column(nullable = false)
    private AccessLvl accessLvl;
}
