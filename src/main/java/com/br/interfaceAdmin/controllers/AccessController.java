package com.br.interfaceAdmin.controllers;

import com.br.interfaceAdmin.dto.AccessDto;
import com.br.interfaceAdmin.dto.UserDto;
import com.br.interfaceAdmin.exception.AccountNotFoundException;
import com.br.interfaceAdmin.services.AccessService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class AccessController {

    private final AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

//    @PostMapping
//    public UserDto authenticationAccess(@RequestBody @Valid AccessDto accessDto) throws AccountNotFoundException {
//        return accessService.check(accessDto);
//    }

    @PostMapping
    public ResponseEntity<?> authenticationAccess(@RequestBody @Valid AccessDto accessDto) {
        try {
            UserDto userDto = accessService.check(accessDto);
            return ResponseEntity.ok(userDto);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
