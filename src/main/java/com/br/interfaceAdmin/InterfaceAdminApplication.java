package com.br.interfaceAdmin;

import com.br.interfaceAdmin.configSecurity.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class InterfaceAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterfaceAdminApplication.class, args);
	}

}
