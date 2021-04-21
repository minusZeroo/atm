package com.jideani.atm.domain;

import java.math.BigDecimal;

public class CheckAccount extends Account {

    private double overDraft;

    public CheckAccount(int id, BigDecimal balance, double overDraft) {
        super(id, balance);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

}
