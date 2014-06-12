package com.iut.bank.business;


import java.util.HashMap;
import java.util.Map;

public class Client {

    private String userCde;
    private String userPwd;
    private boolean isManager;
	private Map<String, Account> accounts;
	private String clientNumber;

	private String lastname;
    private String firstname;
    private String address;

    public Client(){
        accounts = new HashMap<String, Account>();
    }

    /**
     * Constructor for Client :
     * @param idClient
     * @param firstname
     * @param lastname
     * @param address
     */
    public Client(String idClient, String firstname, String lastname, String address) {
        setClientNumber(idClient);
        setFirstname(firstname);
        setLastname(lastname);
        setAddress(address);
        this.accounts = new HashMap<String, Account>();
    }


    public String getUserCde() {
        return userCde;
    }
    
    public String getUserPwd() {
        return userPwd;
    }
    
    public boolean isManager(){
    	return isManager;
    }

    public void setClientNumber(String idClient) {
        this.clientNumber = idClient;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if(lastname != null)
            this.lastname = lastname;
        else
            throw new IllegalArgumentException("Saisir un lastname");
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if(firstname != null)
            this.firstname = firstname;
        else
            throw new IllegalArgumentException("Saisir un firstname");
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        this.accounts.put(account.getAccountNumber(), account);

    }

    public void SetAuthorizations(String userCde, String userPwd, boolean isManager) {
        this.userCde = userCde;
        this.userPwd = userPwd;
        this.isManager = isManager;
        System.out.println("Authorizations has been configured for " + this.userCde);
        System.out.println("Password is : " + this.userPwd);
        System.out.println("Is Manager : " + this.isManager);
    }

    @Override
    public String toString() {
        return "Client Number(" + this.clientNumber + ") has " + this.accounts.size() + " account(s).";
    }
}
