package com.br.interfaceAdmin.config;

import com.br.interfaceAdmin.model.entity.CompareCpfAndCnpj;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CompareCpfAndCnpj compareCpfAndCnpj() {
        return new CompareCpfAndCnpj();
    }
}
