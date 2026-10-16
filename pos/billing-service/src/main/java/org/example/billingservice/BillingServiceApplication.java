package org.example.billingservice;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.entities.ProductItem;
import org.example.billingservice.repositories.BillRepository;
import org.example.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            BillRepository billRepository,
            ProductItemRepository productItemRepository
    ){
        return args -> {
            List<Long> customerIds = List.of(1L, 2L, 3L, 4L);
            List<Long> productIds = List.of(1L,2L,3L,4L);
            customerIds.forEach(clientId->{
                Bill bill = new Bill();
                bill.setCustomerId(clientId);
                bill.setBillingDate(new Date());
                billRepository.save(bill);

                productIds.forEach(productId->{
                    ProductItem productItem = new ProductItem();
                    productItem.setProductId(productId);
                    productItem.setBill(bill);
                    productItem.setQuantity(112);
                    productItemRepository.save(productItem);
                });
            });

        };
    }
}
