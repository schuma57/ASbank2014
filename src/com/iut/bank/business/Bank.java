package com.iut.bank.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.iut.bank.exceptions.BankException;

public class Bank {

    private int bankNum;
    private String bankName;
	private Map<String, Client> clients;
	private Map<String, Account> accounts;
    

    public Bank(int numBank, String bankName){
        this.bankNum = numBank;
        this.bankName = bankName;
        clients = new HashMap<String, Client>();
        accounts = new HashMap<String, Account>();
    }
    
    public int getBankNum(){
    	return bankNum;
    }
    
    public String getBankName(){
    	return bankName;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
    
    @SuppressWarnings("rawtypes")
	public void setClients(Map<String, Client> clients) {
		this.clients = clients;
		System.out.println("The bank has " + this.clients.size()
				+ " client(s).");
		Iterator itClient = this.clients.entrySet().iterator();
		while (itClient.hasNext()) {
			Map.Entry entryClient = (Map.Entry) itClient.next();
			Client c = (Client) entryClient.getValue();
			Iterator itAccount = c.getAccounts().entrySet().iterator();
			while (itAccount.hasNext()) {
				Map.Entry entryAccount = (Map.Entry) itAccount.next();
				Account a = (Account) entryAccount.getValue();
				this.accounts.put(a.getAccountNumber(), a);
			}
		}
		System.out.println("The bank manages " + this.accounts.size()
				+ " account(s).");
	}

	public Account debit(String accountNum, String clientNum, double amount)
	throws BankException {
		Client client = this.clients.get(clientNum);
		Account account = client.getAccounts().get(accountNum);
		if (account != null) {
			if (account.debit(amount))
				return account;
			else
				throw new BankException("'Retrait' is impossible", true, false,
						null);
		} else 
			throw new BankException(
					"'Retrait' is impossible / Compte n'existe pas ", true,
					false, null);
	}
	
	public Account deposit(String accountNum, String clientNum, double amount)
	throws BankException {
		Client client = this.clients.get(clientNum);
		Account account = client.getAccounts().get(accountNum);
		if (account != null) {
			account.credit(amount);
			return account;
		} else
			throw new BankException(
					"'Retrait' is impossible / Compte n'existe pas ", true,
					false, null);
	}
	
	public void openAccount(Client client){
		this.clients.put(client.getClientNumber(), client);
		for (Iterator<Map.Entry<String, Account>> iterator = client
				.getAccounts().entrySet().iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			this.accounts.put(account.getAccountNumber(), account);
		}
	}
	
	public double consultation(String accountNum){
		Account account = this.accounts.get(accountNum);
		return account.getBalance();
	}
	
	public double conversionFromEuro(double montant){
		System.out.println("Conversion Euro ==> Riel cambodgien");// la c'est enorme
        System.out.println("valeur : " +(montant*5523.69));
		return (montant*5523.69);
	}
	
	public double conversionToEuro(double montant){
        System.out.println("Conversion Riel ==> Euro");
        System.out.println("valeur : " +(montant/5523.69));
        return (montant/5523.69);
	}

}
