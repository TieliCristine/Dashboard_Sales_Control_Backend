package com.br.interfaceAdmin.Controller;

import com.br.interfaceAdmin.model.entity.Budget;
import com.br.interfaceAdmin.service.BudgetService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/budget")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public @ResponseBody List<Budget> list(){
        return budgetService.list();
    }

    @GetMapping(value = "/{id}")
    public Budget findById(@PathVariable @NotNull @Positive Long id){
        return budgetService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Budget save(@RequestBody @Valid Budget budget){
        return budgetService.save(budget);
    }

    @PutMapping(value = "/{id}")
    public Budget update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Budget budget){
        return budgetService.update(id, budget);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        budgetService.delete(id);
    }
}
