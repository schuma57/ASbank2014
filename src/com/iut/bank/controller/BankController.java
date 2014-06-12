package com.iut.bank.controller;


import com.iut.bank.business.Account;
import com.iut.bank.exceptions.BankException;
import com.iut.bank.facade.BankFacade;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by schuma on 23/05/14.
 */
public class BankController extends ActionSupport{
   
	private static final long serialVersionUID = 1024L;

	private BankFacade myBank = null;
	
	private Account account;
	private String clientNumber;
	private String accountNumber;
	private double amount;
	private String bankMessage;
	
	public BankController() {
		System.out.println("In Constructor from 'Bankman' class ...");
		this.myBank = new BankFacade();
	}

	
	public String getBankMessage() {
		return bankMessage;
	}
	public void setBankMessage(String bankMessage) {
		this.bankMessage = bankMessage.trim();
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber.trim();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber.trim();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/***
	 * Call the 'facade' to do the credit operation :
	 * @return
	 */
	public String depot() {
		System.out.println("-------> DEPOT");
		System.out.println("- Client Number : " + this.getClientNumber());
		System.out.println("- Account Number : " + this.getAccountNumber());
		System.out.println("- Amount = " + this.getAmount());
		try {
			setAccount(this.myBank.depot(this.getAccountNumber(), this.getClientNumber(), this.getAmount()));
			myBank.updateAccount(this.getAccount());
			return ActionSupport.SUCCESS;
		} catch (BankException e) {
			setBankMessage(e.getMessage());
			return "ERROR";
		}
	}

	/***
	 * Call the 'facade' to do the drawal operation :
	 * @return
	 */
	public String retrait() {
		System.out.println("-------> RETRAIT");
		System.out.println("- Client Number : " + this.getClientNumber());
		System.out.println("- Account Number : " + this.getAccountNumber());
		System.out.println("- Amount = " + this.getAmount());
		try {
			setAccount(this.myBank.retrait(this.getAccountNumber(), this.getClientNumber(), this.getAmount()));
			myBank.updateAccount(this.getAccount());
			return ActionSupport.SUCCESS;
		} catch (BankException e) {
			setBankMessage(e.getMessage());
			return "ERROR";
		}
	}
}
