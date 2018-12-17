package com.samuele.orm;

import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.samuele.orm.repositories.*;

@SpringBootApplication
public class OrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AeroportoRepository aeroportoRepository) {
		return (args) -> {
			// Used to populate db
			// userRepository.save(new User("Mario", "Rossi", "mario.rossi@example.org"));
		};
	}
}
