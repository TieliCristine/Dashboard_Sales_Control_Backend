package com.br.interfaceAdmin.controller;

import com.br.interfaceAdmin.model.entity.Supplier;
import com.br.interfaceAdmin.service.SupplierService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public @ResponseBody List<Supplier> list(){
        return supplierService.list();
    }

    @GetMapping(value = "/{id}")
    public Supplier findById(@PathVariable @NotNull @Positive Long id){
        return supplierService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Supplier save(@RequestBody @Valid Supplier supplier){
        return supplierService.save(supplier);
    }

    @PutMapping(value = "/{id}")
    public Supplier update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Supplier supplier){
        return supplierService.update(id, supplier);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        supplierService.delete(id);
    }
}
