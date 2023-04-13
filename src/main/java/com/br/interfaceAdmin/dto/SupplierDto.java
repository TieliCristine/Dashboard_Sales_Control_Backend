package com.br.interfaceAdmin.dto;

import com.br.interfaceAdmin.model.entity.Address;
import com.br.interfaceAdmin.model.entity.PersonalData;
import com.br.interfaceAdmin.model.entity.Supplier;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierDto {

    private long id;

    @NotBlank(message = "{corporativeName.not.blank}")
    private String corporativeName;

    @NotBlank(message = "{salesRepresentative.not.blank}")
    private String salesRepresentative;

    @NotBlank(message = "{address.not.blank}")
    private Address address;

    @NotBlank(message = "{personalData.not.blank}")
    private PersonalData personalData;

    public SupplierDto(Supplier supplier) {
        this.id = supplier.getId();
        this.corporativeName = supplier.getCorporativeName();
        this.salesRepresentative = supplier.getSalesRepresentative();
        this.address = supplier.getAddress();
        this.personalData = supplier.getPersonalData();
    }
}