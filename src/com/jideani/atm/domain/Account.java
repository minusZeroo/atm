package com.jideani.atm.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private int id;
    private BigDecimal balance;
    private LocalDate dateChanged;

    public Account(int id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(LocalDate dateChanged) {
        this.dateChanged = dateChanged;
    }

    public void withdraw(BigDecimal debit) {
        if (this.balance.compareTo(debit) > 0)
            this.balance = this.balance.subtract(debit);
    }

    public void deposit(BigDecimal credit) {
        this.balance = this.balance.add(credit);
    }


}
