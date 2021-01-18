package com.mvol;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.mvol.entities.Vol;
import com.mvol.repositories.VolRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceVolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceVolApplication.class, args);
	}
	
	CommandLineRunner start(VolRepository volRepository) {
		return (args) -> {
			Stream.of(new Vol("Madrid", "vol madrid"), new Vol("paris", " vol paris"), new Vol("NY", " vol NY"), new Vol("London ", "vol London"))
					.forEach((v) -> {
						volRepository.save(v);
					});

		};
	}
}
