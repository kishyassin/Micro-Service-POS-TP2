package org.example.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
@CircuitBreaker(name = "customer-service" , fallbackMethod = "getDefaultCustomer")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{customerId}")
    Customer findCustomerById(@PathVariable Long customerId);

    default Customer getDefaultCustomer(Long customerId) {
        Customer customer = new Customer();
        customer.setId(null);
        customer.setName("Default");
        return customer;
    }
}
