package beans;

import java.io.Serializable;

public class BankAccount implements Serializable {
        private String accountHolder;
        private double balance;
        public BankAccount() {
        this.accountHolder = "Tanmay";
        this.balance = 0.0;
 }
 public String getAccountHolder() {
     return accountHolder;
 }
 public void setAccountHolder(String accountHolder) {
    this.accountHolder = accountHolder;
 }
 public double getBalance() {
    return balance;
 }
 public void deposit(double amount) {
    if (amount > 0) {
    balance += amount;
    }
 }
 public boolean withdraw(double amount) {
 if (amount > 0 && amount <= balance) {
        balance -= amount;
        return true;
 }
 return false;
 }
}
