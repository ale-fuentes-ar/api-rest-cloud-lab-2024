package edu.alejandro.domain.model;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonthBalance() {
        return monthBalance;
    }

    public void setMonthBalance(String monthBalance) {
        this.monthBalance = monthBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
