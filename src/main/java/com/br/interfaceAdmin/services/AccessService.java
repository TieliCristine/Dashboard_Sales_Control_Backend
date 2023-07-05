package com.br.interfaceAdmin.services;

import com.br.interfaceAdmin.dto.AccessDto;
import com.br.interfaceAdmin.dto.UserDto;
import com.br.interfaceAdmin.exception.AccountNotFoundException;
import com.br.interfaceAdmin.model.entity.User;
import com.br.interfaceAdmin.model.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
@Service
public class AccessService {

    private final UserRepository userRepository;

    public AccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto check(@Valid AccessDto accessDto) throws AccountNotFoundException {
        Optional<User> fetchedRecord = userRepository.findByEmailAndPassword(accessDto.getEmail(), accessDto.getPassword());
        if (fetchedRecord.isPresent() && fetchedRecord.get().getPassword().equals(accessDto.getPassword())) {
            return new UserDto(fetchedRecord.get());
        }
        throw new AccountNotFoundException("Account not found.");
    }

}
