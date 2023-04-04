package com.br.interfaceAdmin.Controller;

import com.br.interfaceAdmin.model.entity.User;
import com.br.interfaceAdmin.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
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
    public @ResponseBody List<User> list(){
        return userService.list();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable @NotNull @Positive Long id){
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody @Valid User user){
        return userService.save(user);
    }

    @PutMapping(value = "/{id}")
    public User update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid User user){
        return userService.update(id, user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@NotNull @Positive Long id){
        userService.delete(id);
    }
}
