package edu.alejandro.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_tramsaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icon;
    private String description;
    @Column(precision = 13, scale = 2)
    private BigDecimal amount;
    private String date;

}
