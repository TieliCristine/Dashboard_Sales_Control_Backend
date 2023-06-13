package com.br.interfaceAdmin.controllers;

import com.br.interfaceAdmin.dto.CustomerDto;
import com.br.interfaceAdmin.model.entity.Customer;
import com.br.interfaceAdmin.services.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public @ResponseBody List<Customer> list(){
        return customerService.list();
    }

    @GetMapping(value = "/{id}")
    public Customer findById(@PathVariable @NotNull @Positive Long id){
        return customerService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody @Valid CustomerDto customerDto){
        Customer customer = customerService.save(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/id/{id}")
    public Customer update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Customer customer){
        return customerService.update(id, customer);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        customerService.delete(id);
    }
}
