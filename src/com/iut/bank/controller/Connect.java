package com.iut.bank.controller;

import java.util.List;
import java.util.Map;

import com.iut.bank.business.Account;
import com.iut.bank.business.Client;
import com.iut.bank.constants.BankConstants;
import com.iut.bank.facade.BankFacade;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Connect extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BankFacade myBank = null;

	private String usrCde;
	private String usrPwd;
	private Client currentUser;
	private List<Account> accounts;
	private List<Client> clients;

	private String clientNumber;

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public Client getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Client currentUser) {
		this.currentUser = currentUser;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getUsrCde() {
		return usrCde;
	}

	public void setUsrCde(String usrCde) {
		this.usrCde = usrCde;
	}

	public String getUsrPwd() {
		return usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

	/***
	 * First call to connect :
	 */
	public Connect() {
		System.out.println("-----------------------------------------");
		System.out.println("- Start Connect >------------------------");
		System.out.println("In Constructor from 'Connect' class ...");
		this.myBank = new BankFacade();
		System.out.println("End Connect >--------------------------");
	}

	@SuppressWarnings("rawtypes")
	public String back() {
		System.out.println("-> Get the session to have the current user ..");
		Map session = ActionContext.getContext().getSession();
		setCurrentUser((Client)session.get("utilisateurconnecte"));
		myBank.checkLogin(this.currentUser.getUserCde(), this.currentUser.getUserPwd());
		setClientNumber(this.currentUser.getClientNumber());
		setAccounts(myBank.getListAccountsForClient());
		return ActionSupport.SUCCESS;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String login() {
		System.out.println("--------------------------------------------");
		System.out.println("- Start Login >-----------------------------");
		System.out.println("- In method 'login' from class 'Connect' ...");
		System.out.println(" 1 - User Cde = " + this.getUsrCde());
		System.out.println(" 2 - User Password = " + this.getUsrPwd());
		System.out.println("--------------------------------------------");
		int result = myBank.checkLogin(this.getUsrCde(), this.getUsrPwd());
		Map session = ActionContext.getContext().getSession();
		System.out.println("*************************************");
		System.out.println("* Put the current user in session .. ");
		System.out.println("*************************************");
		switch (result) {
		case BankConstants.CONNECTION_ERROR:
			return "ERROR";
		case BankConstants.USER_IS_CONNECTED:
			setCurrentUser(myBank.getCurrentClient());
			setAccounts(myBank.getListAccountsForClient());
			setClientNumber(this.currentUser.getClientNumber());
			session.put("utilisateurconnecte", this.getCurrentUser());
			return ActionSupport.SUCCESS;
		case BankConstants.MANAGER_IS_CONNECTED:
			setCurrentUser(myBank.getCurrentClient());
			setClients(myBank.getListClients());
			System.out.println("------------------- CONTROLLER --------------------------");
			System.out.println("- The bank has " + this.getClients().size() + " client(s) ..");
			System.out.println("  first client has " + this.getClients().get(0).getAccounts().size() + " account(s)");
			setAccounts(myBank.getAllAccountsInBank());
			System.out.println("- The bank has also " + this.getAccounts().size() + " account(s) ..");
			System.out.println("------------------- CONTROLLER --------------------------");
			setClientNumber(this.currentUser.getClientNumber());
			session.put("utilisateurconnecte", this.getCurrentUser());
			return "LISTCLIENTS";
		default:
			System.out.println("Unknown error.");
			return "ERROR";
		}
	}
}
