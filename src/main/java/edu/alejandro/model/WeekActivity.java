package edu.alejandro.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_weekactivity")
public class WeekActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 13, scale = 2)
    private BigDecimal amountIn;
    @Column(precision = 13, scale = 2)
    private BigDecimal amountOut;
}
