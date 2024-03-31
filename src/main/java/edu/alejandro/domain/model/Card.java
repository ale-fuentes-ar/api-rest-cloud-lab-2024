package edu.alejandro.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String name;
    private String valid;
    @Column(name= "card_limit", precision = 13, scale = 2)
    private BigDecimal cardLimit;
}
