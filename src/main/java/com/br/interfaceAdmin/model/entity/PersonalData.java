package com.br.interfaceAdmin.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PersonalData")
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(length = 14, unique = true)
    private String cnpj;

    @NotBlank
    @Column(length = 11, nullable = false)
    private String phone;

    @NotBlank
    @Column(nullable = false)
    private String email;

    public boolean hasCpfOrCnpj() {
        return cpf == null && cnpj == null;
    }
}
