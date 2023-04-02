package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.model.entity.Address;
import com.br.interfaceAdmin.model.repository.AddressRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> list(){
        return addressRepository.findAll();
    }

    public Address findById(@NotNull @Positive Long id){
        return addressRepository.findById(id).orElseThrow();
    }

    public Address save(@Valid Address address){
        return addressRepository.save(address);
    }

    public Address update(@NotNull @Positive Long id, @Valid Address address){
        return addressRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setZipCode(address.getZipCode());
                    recordFound.setStreet(address.getStreet());
                    recordFound.setNumber(address.getNumber());
                    recordFound.setSupplemental(address.getSupplemental());
                    recordFound.setDistrict(address.getDistrict());
                    recordFound.setCity(address.getCity());
                    recordFound.setState(address.getState());
                    return addressRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id){
        addressRepository.delete(addressRepository.findById(id).orElseThrow());
    }
}
