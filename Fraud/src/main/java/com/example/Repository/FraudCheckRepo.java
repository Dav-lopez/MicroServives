package com.example.Repository;

import com.example.Model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckRepo extends JpaRepository<FraudCheckHistory, Integer> {
}
