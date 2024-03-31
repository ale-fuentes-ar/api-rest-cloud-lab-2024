package edu.alejandro.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Card> cards;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> transactions;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WeekActivity> weekActivities;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ExpenseStatistics> expenseStatistics;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<QuickTransfer> quickTransfers;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BalanceHistory> balanceHistories;

}
