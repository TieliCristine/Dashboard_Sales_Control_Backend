package com.br.interfaceAdmin.controller;

import com.br.interfaceAdmin.model.entity.Address;
import com.br.interfaceAdmin.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> list(){
        return addressService.list();
    }

    @PostMapping(value = "/registerAddress")
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping
    public Address update(@RequestBody Address address){
        return addressService.save(address);
    }
}
