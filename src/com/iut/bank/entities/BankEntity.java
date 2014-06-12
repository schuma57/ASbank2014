package com.iut.bank.entities;

import java.util.List;

/**
 * Created by schuma on 23/05/14.
 */
public class BankEntity {
    private int bankId;
    private String bankName;

    private List<ClientEntity> clients;
    private List<AccountEntity> accounts;


    public int getBankId() {
        return bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public List<ClientEntity> getClients() {
        return clients;
    }
    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }
    public List<AccountEntity> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }

}
