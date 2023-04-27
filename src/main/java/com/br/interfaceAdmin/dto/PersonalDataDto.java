package com.br.interfaceAdmin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonalDataDto {

    private long id;

    @NotBlank(message = "{cpf.not.blank}")
    private String cpf;

    @NotBlank(message = "{cnpj.not.blank}")
    private String cnpj;

    @NotBlank(message = "{phone.not.blank}")
    private String phone;

    @NotBlank(message = "{email.not.blank}")
    private String email;
}
