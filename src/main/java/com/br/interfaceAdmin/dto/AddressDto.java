package com.br.interfaceAdmin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {

    private long id;

    @NotBlank(message = "{zipCode.not.blank}")
    private String zipCode;

    @NotBlank(message = "{street.not.blank}")
    private String street;

    @NotBlank(message = "{number.not.blank}")
    private String number;

    private String supplemental;

    @NotBlank(message = "{district.not.blank}")
    private String district;

    @NotBlank(message = "{city.not.blank}")
    private String city;

    @NotBlank(message = "{state.not.blank}")
    private String state;
}
