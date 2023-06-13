package com.br.interfaceAdmin.services;

import com.br.interfaceAdmin.model.entity.PersonalData;
import com.br.interfaceAdmin.model.repository.PersonalDataRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    public PersonalDataService(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    public List<PersonalData> list() {
        return personalDataRepository.findAll();
    }

    public PersonalData findById(@NotNull @Positive Long id) {
        return personalDataRepository.findById(id).orElseThrow();
    }

    public PersonalData save(@Valid PersonalData personalData) {
        return personalDataRepository.save(personalData);
    }

    public PersonalData update(@NotNull @Positive Long id, @Valid PersonalData personalData) {
        return personalDataRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setCpf(personalData.getCpf());
                    recordFound.setCnpj(personalData.getCnpj());
                    recordFound.setPhone(personalData.getPhone());
                    recordFound.setEmail(personalData.getEmail());
                    return personalDataRepository.save(recordFound);
                }).orElseThrow();
    }
}
