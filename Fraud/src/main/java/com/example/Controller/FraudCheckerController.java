package com.example.Controller;


import com.example.Model.FraudCheckResponse;
import com.example.Service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class FraudCheckerController {
   @Autowired
    private FraudCheckService fraudCheckService;

    @GetMapping("/checkfraud/{customerID}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerID){
        boolean isFraudCustomer = fraudCheckService.isFraudulentCustomer(customerID);

        log.info("checking logs for customer{}", customerID);
        return new FraudCheckResponse(isFraudCustomer);

    }

}
