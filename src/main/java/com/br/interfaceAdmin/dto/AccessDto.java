package com.br.interfaceAdmin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccessDto {

//    @NotBlank(message = "{email.not.blank}")
    private String email;

//    @NotBlank(message = "{password.not.blank}")
    private String password;
}
