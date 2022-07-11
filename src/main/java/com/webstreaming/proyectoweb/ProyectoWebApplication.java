package com.webstreaming.proyectoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		AppConfig.class
})
public class ProyectoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoWebApplication.class, args);
	}

}
