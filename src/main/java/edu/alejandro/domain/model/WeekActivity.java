package edu.alejandro.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_week_activity")
public class WeekActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "activity_day")
    private String activityDay;
    @Column(name = "amount_in", precision = 13, scale = 2)
    private BigDecimal amountIn;
    @Column(name = "amount_out", precision = 13, scale = 2)
    private BigDecimal amountOut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityDay() {
        return activityDay;
    }

    public void setActivityDay(String activityDay) {
        this.activityDay = activityDay;
    }

    public BigDecimal getAmountIn() {
        return amountIn;
    }

    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    public BigDecimal getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }
}
