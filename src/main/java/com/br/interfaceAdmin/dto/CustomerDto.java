package com.br.interfaceAdmin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CustomerDto {

    private long id;

    @NotBlank(message = "{name.not.blank}")
    private String name;

    private Date birthdate;

    @NotNull(message = "{address.not.null}")
    private AddressDto address;

    @NotNull(message = "{personalData.not.null}")
    private PersonalDataDto personalData;
}
