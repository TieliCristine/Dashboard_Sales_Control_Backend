package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.dto.SupplierDto;
import com.br.interfaceAdmin.model.entity.CompareCpfAndCnpj;
import com.br.interfaceAdmin.model.entity.PersonalData;
import com.br.interfaceAdmin.model.entity.Supplier;
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
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final CompareCpfAndCnpj compareCpfAndCnpj;

    public SupplierService(SupplierRepository supplierRepository, ModelMapper modelMapper, CompareCpfAndCnpj compareCpfAndCnpj) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.compareCpfAndCnpj = compareCpfAndCnpj;
    }

    public List<Supplier> list() {
        return supplierRepository.findAll();
    }

    public Supplier findById(@NotNull @Positive Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    public Supplier save(@Valid SupplierDto supplierDto){
        Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
        PersonalData personalData = supplier.getPersonalData();
        if (personalData.hasCpfOrCnpj()) {
            throw new IllegalArgumentException("PersonalData must have at least cpf or cnpj filled");
        }
        return supplierRepository.save(supplier);
    }

    public Supplier update(@NotNull @Positive Long id, @Valid Supplier supplier) {
        return supplierRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setCorporativeName(supplier.getCorporativeName());
                    recordFound.setSalesRepresentative(supplier.getSalesRepresentative());
                    recordFound.setAddress(supplier.getAddress());
                    String recordFoundCpf = recordFound.getPersonalData().getCpf();
                    String receivedCpf = supplier.getPersonalData().getCpf();
                    if (this.compareCpfAndCnpj.compareCpf(recordFoundCpf, receivedCpf)) {
                        recordFound.getPersonalData().setCpf(supplier.getPersonalData().getCpf());
                    }
                    String recordFoundCnpj = recordFound.getPersonalData().getCnpj();
                    String receivedCnpj = supplier.getPersonalData().getCnpj();
                    if (this.compareCpfAndCnpj.compareCnpj(recordFoundCnpj, receivedCnpj)) {
                        recordFound.getPersonalData().setCnpj(supplier.getPersonalData().getCnpj());
                    }
                    recordFound.getPersonalData().setPhone(supplier.getPersonalData().getPhone());
                    recordFound.getPersonalData().setEmail(supplier.getPersonalData().getEmail());
                    return supplierRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id) {
        supplierRepository.delete(supplierRepository.findById(id).orElseThrow());
    }
}
