package com.example.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(name = "Fraud_id_seq",
    sequenceName = "Fraud_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "Fraud_id_seq")
    private Integer id;
    private Integer CustomerId;
    private boolean isfraudSter;
    private LocalDateTime createdAt;
}
