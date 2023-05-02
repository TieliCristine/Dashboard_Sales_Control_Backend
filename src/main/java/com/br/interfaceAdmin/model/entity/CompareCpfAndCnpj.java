package com.br.interfaceAdmin.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class CompareCpfAndCnpj {

    private String compareCpf;
    private String compareCnpj;

    public boolean compareCpf(String recordFoundCpf, String receivedCpf){
        return !Objects.equals(recordFoundCpf, receivedCpf);
    }

    public boolean compareCnpj(String recordFoundCnpj, String receivedCnpj){
        return !Objects.equals(recordFoundCnpj, receivedCnpj);
    }
}
