package com.example.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaEmbeddableDemoApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(JpaEmbeddableDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		userRepository.deleteAllInBatch();
//
//		Name name = new Name("Hemang", "N", "Rami");
//		Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008");
//		User user = new User(name, "ramihemang@gmail.com", address);
//
//		userRepository.save(user);
	}
}
