package org.example.billingservice.web;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.entities.ProductItem;
import org.example.billingservice.feign.CustomerServiceRestClient;
import org.example.billingservice.feign.InvantoryServiceRestClient;
import org.example.billingservice.model.Customer;
import org.example.billingservice.repositories.BillRepository;
import org.example.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InvantoryServiceRestClient invantoryServiceRestClient;

    @GetMapping("/bills/{billId}")
    public Bill getBillById(@PathVariable long billId) {
        Bill bill = billRepository.findById(billId).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);

        List<ProductItem> productItems = productItemRepository.findByBillId(billId);
        bill.setProductItems(productItems);
        return bill;
    }
}
