package com.br.interfaceAdmin.services;

import com.br.interfaceAdmin.dto.AccessDto;
import com.br.interfaceAdmin.dto.UserDto;
import com.br.interfaceAdmin.exception.AccountNotFoundException;
import com.br.interfaceAdmin.model.entity.User;
import com.br.interfaceAdmin.model.projection.UserProjection;
import com.br.interfaceAdmin.model.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Validated
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserProjection> list(){
        return userRepository.findAllProjectedBy();
    }

    public User findById(@NotNull @Positive Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(@Valid UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
//        if (requestingUser.getAccessLvl() != AccessLvl.ADMIN) {
//            user.setAccessLvl(AccessLvl.LOW);
//        }
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
                    recordFound.setJobPosition(user.getJobPosition());
                    return userRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@org.jetbrains.annotations.NotNull @Positive Long id){
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }
}
