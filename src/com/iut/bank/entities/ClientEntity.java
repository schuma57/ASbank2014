package com.iut.bank.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by schuma on 23/05/14.
 */
public class ClientEntity implements Serializable{
    private static final long serialVersionUID = 1010L;

    private int idBanque;
    private String idClient;
    private String name;
    private String firstname;
    private String address;
    private String login;
    private String password;
    private boolean isManager;
    private List<AccountEntity> accounts;


    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public int getIdBanque() {
        return idBanque;
    }

    public void setIdBanque(int idBanque) {
        this.idBanque = idBanque;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String user) {
        this.login = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userPwd) {
        this.password = userPwd;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(int profile) {
        if(profile == 1)
        	isManager = false;
        else if(profile == 2)
        	isManager = true;
    }

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }
}
