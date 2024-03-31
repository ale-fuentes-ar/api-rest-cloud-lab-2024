package edu.alejandro.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<WeekActivity> getWeekActivities() {
        return weekActivities;
    }

    public void setWeekActivities(List<WeekActivity> weekActivities) {
        this.weekActivities = weekActivities;
    }

    public List<ExpenseStatistics> getExpenseStatistics() {
        return expenseStatistics;
    }

    public void setExpenseStatistics(List<ExpenseStatistics> expenseStatistics) {
        this.expenseStatistics = expenseStatistics;
    }

    public List<QuickTransfer> getQuickTransfers() {
        return quickTransfers;
    }

    public void setQuickTransfers(List<QuickTransfer> quickTransfers) {
        this.quickTransfers = quickTransfers;
    }

    public List<BalanceHistory> getBalanceHistories() {
        return balanceHistories;
    }

    public void setBalanceHistories(List<BalanceHistory> balanceHistories) {
        this.balanceHistories = balanceHistories;
    }
}
