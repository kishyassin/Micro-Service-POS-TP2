package org.example.billingservice.feign;

import org.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("invantory-service")
public interface InvantoryServiceRestClient {

    @GetMapping("/products/{productId}")
    Product findProductById(@PathVariable Long productId);
}
