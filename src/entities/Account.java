package entities;

import exceptions.BusinessException;

public class Account {

    private int number;
    private String holder;
    private double balance;
    private double limitWithdraw;

    public Account(int number, String holder, double limitWithdraw) {
        this.number = number;
        this.holder = holder;
        this.limitWithdraw = limitWithdraw;
    }

    public Account(int number, String holder, double balance, double limitWithdraw) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.limitWithdraw = limitWithdraw;
    }

    public int getNumber() {
        return number;
    }


    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getLimitWithdraw() {
        return limitWithdraw;
    }

    public void changeName(String holder) {
        this.holder = holder;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    public void changeLimitWithdraw(double amount){
        limitWithdraw = amount;
    }

    public void validateWithdraw(double amount){
        if (amount > balance){
            throw new BusinessException("Not enough balance");
        }
        if (amount > limitWithdraw){
            throw new BusinessException("The amount exceeds withdraw limit");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account number: ");
        sb.append(number + "\n");
        sb.append("Account holder: ");
        sb.append(holder + "\n");
        sb.append("Limit withdraw: $");
        sb.append(String.format("%.2f%n", limitWithdraw));
        sb.append("Current Balance: $");
        sb.append(String.format("%.2f", balance));
        return sb.toString();
    }

}
