package com.br.interfaceAdmin.dto;

import com.br.interfaceAdmin.model.entity.Address;
import com.br.interfaceAdmin.model.entity.Customer;
import com.br.interfaceAdmin.model.entity.PersonalData;
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

    @NotBlank(message = "{birthdate.not.blank}")
    private Date birthdate;

    @NotNull(message = "{address.not.null}")
    private Address address;

    @NotNull(message = "{personalData.not.null}")
    private PersonalData personalData;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.birthdate = customer.getBirthdate();
        this.address = customer.getAddress();
        this.personalData = customer.getPersonalData();
    }
}
