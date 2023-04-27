package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.dto.CustomerDto;
import com.br.interfaceAdmin.model.entity.Customer;
import com.br.interfaceAdmin.model.entity.PersonalData;
import com.br.interfaceAdmin.model.repository.CustomerRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Customer findById(@NotNull @Positive Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public Customer save(@Valid CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        PersonalData personalData = customer.getPersonalData();
        if (!personalData.hasCpfOrCnpj()){
            throw new IllegalArgumentException("PersonalData must have at least cpf or cnpj filled");
        }
        return customerRepository.save(customer);
    }

    public Customer update(@NotNull @Positive Long id, @Valid Customer customer) {
        return customerRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(customer.getName());
                    recordFound.setBirthdate(customer.getBirthdate());
                    recordFound.setAddress(customer.getAddress());
                    recordFound.setPersonalData(customer.getPersonalData());
                    return customerRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id) {
        customerRepository.delete(customerRepository.findById(id)
                .orElseThrow());
    }
}
