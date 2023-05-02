package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.dto.CustomerDto;
import com.br.interfaceAdmin.model.entity.CompareCpfAndCnpj;
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
import java.util.Objects;

@Validated
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final CompareCpfAndCnpj compareCpfAndCnpj;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper, CompareCpfAndCnpj compareCpfAndCnpj) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.compareCpfAndCnpj = compareCpfAndCnpj;
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
        if (personalData.hasCpfOrCnpj()) {
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
                    String recordFoundCpf = recordFound.getPersonalData().getCpf();
                    String receivedCpf = customer.getPersonalData().getCpf();
                    if (this.compareCpfAndCnpj.compareCpf(recordFoundCpf, receivedCpf)) {
                        recordFound.getPersonalData().setCpf(customer.getPersonalData().getCpf());
                    }
                    String recordFoundCnpj = recordFound.getPersonalData().getCnpj();
                    String receivedCnpj = customer.getPersonalData().getCnpj();
                    if (this.compareCpfAndCnpj.compareCnpj(recordFoundCnpj, receivedCnpj)) {
                        recordFound.getPersonalData().setCnpj(customer.getPersonalData().getCnpj());
                    }
                    recordFound.getPersonalData().setPhone(customer.getPersonalData().getPhone());
                    recordFound.getPersonalData().setEmail(customer.getPersonalData().getEmail());
                    return customerRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id) {
        customerRepository.delete(customerRepository.findById(id)
                .orElseThrow());
    }
}
