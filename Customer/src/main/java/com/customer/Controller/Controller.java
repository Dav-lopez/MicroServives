package com.customer.Controller;

import com.customer.Model.Customer;
import com.customer.Model.CustomerRegDetails;
import com.customer.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping
public record Controller (CustomerService customerService) {

    @PostMapping("/registerCustomer")
    public void RegisterCustomer(@RequestBody CustomerRegDetails customerRegDetails){
        log.info("new customer registered {}", customerRegDetails);
        customerService.registerCustomer(customerRegDetails);


    }

}
