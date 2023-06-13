package com.br.interfaceAdmin.controllers;

import com.br.interfaceAdmin.dto.AccessDto;
import com.br.interfaceAdmin.dto.UserDto;
import com.br.interfaceAdmin.model.entity.User;
import com.br.interfaceAdmin.model.projection.UserProjection;
import com.br.interfaceAdmin.services.UserService;
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
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody List<UserProjection> list(){
        return userService.list();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable @NotNull @Positive Long id){
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserDto userDto){
        User user = userService.save(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<User> authenticationAccess(@RequestBody @Valid AccessDto accessDto){
        User user = userService.check(accessDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/id/{id}")
    public User update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid User user){
        return userService.update(id, user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@NotNull @Positive Long id){
        userService.delete(id);
    }
}
