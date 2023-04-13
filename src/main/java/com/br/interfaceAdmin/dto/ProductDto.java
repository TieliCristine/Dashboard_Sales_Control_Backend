package com.br.interfaceAdmin.dto;

import com.br.interfaceAdmin.model.entity.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @NotBlank(message = "{name.not.blank}")
    private String name;

    @NotBlank(message = "{description.not.blank}")
    private String description;

    @NotBlank(message = "{price.not.blank}")
    private double price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}




