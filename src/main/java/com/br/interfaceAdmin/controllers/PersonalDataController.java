package com.br.interfaceAdmin.controllers;

import com.br.interfaceAdmin.model.entity.PersonalData;
import com.br.interfaceAdmin.services.PersonalDataService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/personalData")
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @GetMapping
    public List<PersonalData> list(){
        return personalDataService.list();
    }

    @GetMapping(value = "/{id}")
    public PersonalData findById(@PathVariable @NotNull @Positive Long id){
        return personalDataService.findById(id);
    }

    @PostMapping(value = "/{id}")
    public PersonalData save(@RequestBody @Valid PersonalData personalData){
        return personalDataService.save(personalData);
    }

    @PutMapping(value = "/{id}")
    public PersonalData update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid PersonalData personalData){
        return personalDataService.update(id, personalData);
    }
}
