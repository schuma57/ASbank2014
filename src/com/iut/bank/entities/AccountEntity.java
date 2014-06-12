package com.iut.bank.entities;

import java.io.Serializable;

/**
 * Created by schuma on 23/05/14.
 */
public class AccountEntity implements Serializable{
    private static final long serialVersionUID = 2L;
    
    private String accountNumber;
    private int idBank;
    private String nameAccount;
    private double balance;
    private double discoveredAuthorised;
    

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String idCompte) {
        this.accountNumber = idCompte;
    }

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDiscoveredAuthorised() {
        return discoveredAuthorised;
    }

    public void setDiscoveredAuthorised(double discoveredAuthorised) {
        this.discoveredAuthorised = discoveredAuthorised;
    }


}
