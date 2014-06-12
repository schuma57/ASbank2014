package com.iut.bank.business;

public abstract class Account {

	protected double balance;
	protected String accountNumber;
	protected String accountName;

	
    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public abstract boolean debit(double amount);

    public void credit(double amount){
        this.balance +=amount;
    }

    @Override
    public String toString() {
        return "Balance of Account Number(" + this.accountNumber  + ") = " + this.balance;
    }
}
