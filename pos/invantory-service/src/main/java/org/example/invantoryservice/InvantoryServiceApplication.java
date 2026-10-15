package org.example.invantoryservice;

import org.example.invantoryservice.entities.Product;
import org.example.invantoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvantoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvantoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product(null, "PC", 12,11));
            productRepository.save(new Product(null, "Phone", 222,89));
            productRepository.save(new Product(null, "TV", 98,34));
            productRepository.save(new Product(null, "Desk", 678,56));
        };
    }
}
