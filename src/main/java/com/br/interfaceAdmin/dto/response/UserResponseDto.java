package com.br.interfaceAdmin.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {

    private long id;

    @NotBlank(message = "{name.not.blank}")
    private String name;

    @NotBlank(message = "{jobPosition.not.blank}")
    private String jobPosition;
}
