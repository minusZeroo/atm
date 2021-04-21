package com.jideani.atm;

import com.jideani.atm.domain.Account;
import com.jideani.atm.domain.CheckAccount;
import com.jideani.atm.domain.SavingsAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {

    private static final double INTEREST_RATE = 12.9, OVER_DRAFT = 9.1;
    private static List<Account> accounts;

    public static void main(String[] args) {
        createAccounts();
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your account ID: ");
            try {
                int id = input.nextInt();
                Account account = getAccountById(id);
                if (account != null) {
                    boolean accountFound = true;
                    while (accountFound) {
                        System.out.println("Main Menu");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Deposit");
                        System.out.println("4. Exit");
                        try {
                            int option = input.nextInt();
                            accountFound = performOperation(option, account, input, accountFound);
                        } catch (Exception e) {
                            System.out.println("Invalid amount!");
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: You entered an invalid ID");
            }
        }
    }

        private static void createAccounts() {
            accounts = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Account account;
                if (i % 2 == 0) {
                    account = new SavingsAccount(i, BigDecimal.ZERO, INTEREST_RATE);
                } else {
                    account = new CheckAccount(i, BigDecimal.ZERO, OVER_DRAFT);
                }
                accounts.add(account);
            }
        }

        private static Account getAccountById(int id) {
            /*for (Account account : accounts) {
                if (account.getId() == id) return account;
            } */
            return accounts.stream()
                    .filter(account -> account.getId() == id)
                    .findAny().orElse(null);
        }

        private static boolean performOperation(int option, Account account, Scanner input, boolean exit) {
            switch (option) {
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 2:
                    withdraw(account, input);
                    break;
                case 3:
                    deposit(account, input);
                    break;
                default:
                    exit = false;
                    System.out.println("Thank you for banking with Jideani");
            }
            return exit;
        }

        private static void withdraw(Account account, Scanner input) {
            System.out.println("How much do you want to withdraw: ");
            BigDecimal amountEntered = input.nextBigDecimal();

            account.withdraw(amountEntered);
        }

        private static void deposit(Account account, Scanner input) {
            System.out.println("How much do you want to deposit: ");
            BigDecimal amountEntered = input.nextBigDecimal();

            account.deposit(amountEntered);
        }
}
