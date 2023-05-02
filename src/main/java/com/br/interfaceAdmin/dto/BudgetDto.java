package com.br.interfaceAdmin.dto;

import com.br.interfaceAdmin.model.entity.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BudgetDto {

    private long id;

    @NotNull(message = "{quantity.not.null}")
    @Positive(message = "{quantity.not.negative}")
    private long quantity;

    private double finalPrice;

    @NotNull(message = "{customer.not.null}")
    private Customer customer;

    @NotNull(message = "{supplier.not.null}")
    private Supplier supplier;

    @NotNull(message = "{product.not.null}")
    private Product product;

    private Status status;

    public BudgetDto(Budget budget) {
        this.quantity = budget.getQuantity();
        this.customer = budget.getCustomer();
        this.supplier = budget.getSupplier();
        this.product = budget.getProduct();
        this.status = budget.getStatus();
    }
}
