package com.customer.Service;

import com.customer.Model.Customer;
import com.customer.Model.CustomerRegDetails;
import com.customer.Model.FraudCheckResponse;
import com.customer.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerRepo repo;
    public void registerCustomer(CustomerRegDetails customerRegDetails) {
        Customer customer = Customer.builder()
                .firstName(customerRegDetails.firstName())
                .lastName(customerRegDetails.lastName())
                .email(customerRegDetails.email())
                .build();

        repo.saveAndFlush(customer);

      FraudCheckResponse fraudCheckResponse =  restTemplate.getForObject(
                "http://localhost:8086/checkfraud/{customerID}",
                FraudCheckResponse.class,customer.getId()
        );

      if(fraudCheckResponse.isFraudster()){
          throw new IllegalStateException("fraudster");
      }

    }
}
