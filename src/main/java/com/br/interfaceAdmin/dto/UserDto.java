package com.br.interfaceAdmin.dto;

import com.br.interfaceAdmin.enumeration.AccessLvl;
import com.br.interfaceAdmin.model.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDto {

    private long id;
    private String email;
    private String cpf;
    private String name;
    private Date birthdate;
    private String jobPosition;
    private AccessLvl accessLvl;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.name = user.getName();
        this.birthdate = user.getBirthdate();
        this.jobPosition = user.getJobPosition();
        this.accessLvl = user.getAccessLvl();
    }
}
