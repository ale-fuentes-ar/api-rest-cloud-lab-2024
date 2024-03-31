package edu.alejandro.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_expenseStatistics")
public class ExpenseStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 4, scale = 2)
    private BigDecimal percent;
    private String description;
}
