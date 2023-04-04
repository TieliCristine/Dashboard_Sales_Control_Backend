package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.model.entity.Supplier;
import com.br.interfaceAdmin.model.repository.SupplierRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> list() {
        return supplierRepository.findAll();
    }

    public Supplier findById(@NotNull @Positive Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    public Supplier save(@Valid Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier update(@NotNull @Positive Long id, @Valid Supplier supplier) {
        return supplierRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setCorporativeName(supplier.getCorporativeName());
                    recordFound.setSalesRepresentative(supplier.getSalesRepresentative());
                    recordFound.setAddress(supplier.getAddress());
                    recordFound.setPersonalData(supplier.getPersonalData());
                    return supplierRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id) {
        supplierRepository.delete(supplierRepository.findById(id).orElseThrow());
    }
}
