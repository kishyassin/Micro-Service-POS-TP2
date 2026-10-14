package org.example.customerservice;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.repositories.CustomerRpository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRpository customerRpository) {
        return args -> {
            customerRpository.save(new Customer(null, "John", "test@gmail.com"));
            customerRpository.save(new Customer(null,"Ali", "test2@gmail.com"));
            customerRpository.save(new Customer(null, "Imane" , "imane@gmail.com"));
        };
    }
}
