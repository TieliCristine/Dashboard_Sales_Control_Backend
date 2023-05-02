package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.dto.BudgetDto;
import com.br.interfaceAdmin.model.entity.*;
import com.br.interfaceAdmin.model.repository.BudgetRepository;
import com.br.interfaceAdmin.model.repository.CustomerRepository;
import com.br.interfaceAdmin.model.repository.ProductRepository;
import com.br.interfaceAdmin.model.repository.SupplierRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final CustomerRepository customerRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public BudgetService(BudgetRepository budgetRepository,
                         CustomerRepository customerRepository,
                         SupplierRepository supplierRepository,
                         ProductRepository productRepository,
                         ModelMapper modelMapper) {
        this.budgetRepository = budgetRepository;
        this.customerRepository = customerRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<Budget> list(){
        return budgetRepository.findAll();
    }

    public Budget findById(@NotNull @Positive Long id){
        return budgetRepository.findById(id).orElseThrow();
    }

    public Budget save(@Valid Budget budget){
        return budgetRepository.save(budget);
    }

    public Budget createBudget(@Valid BudgetDto budgetDto) {
        Budget budget = this.modelMapper.map(budgetDto, Budget.class);


        return budgetRepository.save(budget);
    }

    public Budget update(@NotNull @Positive Long id, @Valid Budget budget){
        return budgetRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setQuantity(budget.getQuantity());
                    recordFound.setCustomer(budget.getCustomer());
                    recordFound.setSupplier(budget.getSupplier());
                    recordFound.setProduct(budget.getProduct());
                    recordFound.setStatus(budget.getStatus());
                    return budgetRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id){
        budgetRepository.delete(budgetRepository.findById(id)
                .orElseThrow());
    }
}
