package edu.alejandro.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_expense_statistics")
public class ExpenseStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 4, scale = 2)
    private BigDecimal percent;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
