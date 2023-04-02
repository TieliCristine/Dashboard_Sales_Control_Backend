package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.model.entity.Budget;
import com.br.interfaceAdmin.model.repository.BudgetRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    private List<Budget> list(){
        return budgetRepository.findAll();
    }

    private Budget findById(@NotNull @Positive Long id){
        return budgetRepository.findById(id).orElseThrow();
    }

    private Budget save(@Valid Budget budget){
        return budgetRepository.save(budget);
    }

    private Budget update(@NotNull @Positive Long id, @Valid Budget budget){
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

    private void delete(@NotNull @Positive Long id){
        budgetRepository.delete(budgetRepository.findById(id)
                .orElseThrow());
    }
}
