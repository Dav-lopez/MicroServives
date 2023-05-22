package com.example.Service;

import com.example.Model.FraudCheckHistory;
import com.example.Repository.FraudCheckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    @Autowired
    private FraudCheckRepo fraudCheckRepo;
    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckRepo.save(
                FraudCheckHistory.builder().CustomerId(customerId)
                        .isfraudSter(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
