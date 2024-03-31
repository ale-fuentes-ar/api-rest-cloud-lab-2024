package edu.alejandro.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_balance_history")
public class BalanceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "month_balance")
    private String monthBalance;
    @Column(precision = 13, scale = 2)
    private BigDecimal amount;

}
