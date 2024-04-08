package com.br.gisiona.apirestwebflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication @Slf4j
public class WebfluxapirestApplication {

	public static void main(String[] args) {
		log.info("Aplicação sendo iniciada na porta: {}", 8081);
		SpringApplication.run(WebfluxapirestApplication.class, args);
	}

}
