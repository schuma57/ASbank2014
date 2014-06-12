package com.iut.bank.facade;

import java.util.List;

import com.iut.bank.business.Account;
import com.iut.bank.business.Client;
import com.iut.bank.constants.BankConstants;
import com.iut.bank.exceptions.BankException;
import com.iut.bank.manager.BankManager;

public class BankFacade {
	private BankManager bankOf;
	private Client client;

	/**
	 * Constructor : Facade
	 */
	public BankFacade() {
		System.out.println("- FACADE DESIGN PATTERN --->");
		System.out.println("'BankFacade' constructor has been created ...");
		this.bankOf = new BankManager();
	}

	/***
	 * 
	 * @param accountNumber
	 * @param clientNumber
	 * @param amount
	 * @return
	 */
	public Account depot(String accountNumber, String clientNumber, double amount) throws BankException {
		try {
			return this.bankOf.getMyBank().deposit(accountNumber, clientNumber, amount);
		} catch (BankException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/***
	 * 
	 * @param accountNumber
	 * @param clientNumber
	 * @param amount
	 * @return
	 * @throws BankException
	 */
	public Account retrait(String accountNumber, String clientNumber, double amount) throws BankException {
		try {
			return this.bankOf.getMyBank().debit(accountNumber, clientNumber, amount);
		}
		catch (BankException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	/***
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Client createNewClient(Client client) {
		return this.bankOf.createNewClientInBank(client);
	}

	/***
	 * return a code to indicate the result of the connection :
	 * 
	 * @param usrCde
	 * @param usrPwd
	 * @return
	 */
	public int checkLogin(String usrCde, String usrPwd) {
		Client client = bankOf.getCurrentUser(usrCde, usrPwd);
		if (client == null)
			return BankConstants.CONNECTION_ERROR;
		else {
			this.client = client;
			if (client.isManager())
				return BankConstants.MANAGER_IS_CONNECTED;
			else
				return BankConstants.USER_IS_CONNECTED;
		}
	}

	/***
	 * 
	 * @return
	 */
	public Client getCurrentClient() {
		if (this.client != null) {
			for (Account account : bankOf.getAccountsFromClient(this.client)) {
				System.out.println(account.toString());
			}
			return this.client;
		} else
			return null;
	}

	/***
	 * 
	 * @return
	 */
	public List<Account> getListAccountsForClient() {
		if (this.client != null) {
			return bankOf.getAccountsFromClient(this.client);
		} else
			return null;
	}

	/***
	 * 
	 * @return
	 */
	public List<Account> getAllAccountsInBank() {
		return bankOf.getAccountsFromBank();
	}
	
	/***
	 * 
	 * @return
	 */
	public List<Client> getListClients() {
		return bankOf.getClientsFromBank();
	}
	
	public void updateAccount(Account account){
		bankOf.updateAccount(account);
	}

}
