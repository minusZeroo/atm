package com.jideani.atm.domain;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

    private double annualInterestRate;

    public SavingsAccount(int id, BigDecimal balance, double annualInterestRate) {
        super(id, balance);
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        BigDecimal monthlyInterestRate = BigDecimal.valueOf(getMonthlyInterestRate());
         return getBalance().multiply(monthlyInterestRate).doubleValue();
    }


}
