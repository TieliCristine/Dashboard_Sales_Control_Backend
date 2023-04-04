package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.model.entity.User;
import com.br.interfaceAdmin.model.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list(){
        return userRepository.findAll();
    }

    public User findById(@NotNull @Positive Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User save(@Valid User user){
        return userRepository.save(user);
    }

    public User update(@NotNull @Positive Long id, @Valid User user){
        return userRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setEmail(user.getEmail());
                    recordFound.setPassword(user.getPassword());
                    recordFound.setCpf(user.getCpf());
                    recordFound.setName(user.getName());
                    recordFound.setBirthdate(user.getBirthdate());
                    recordFound.setCargo(user.getCargo());
                    return userRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id){
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }
}
