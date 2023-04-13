package com.br.interfaceAdmin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDto {

    private long id;

    @NotBlank(message = "{email.not.blank}")
    private String email;

    @NotBlank(message = "{password.not.blank}")
    private String password;

    @NotBlank(message = "{cpf.not.blank}")
    private String cpf;

    @NotBlank(message = "{name.not.blank}")
    private String name;

    @NotNull(message = "{birthdate.not.null}")
    private Date birthdate;

    @NotBlank(message = "{jobPosition.not.blank}")
    private String jobPosition;
}
