package com.iut.bank.controller;

import com.iut.bank.business.Client;
import com.iut.bank.exceptions.BankException;
import com.iut.bank.facade.BankFacade;
import com.opensymphony.xwork2.ActionSupport;

public class NewClientController extends ActionSupport {
	private static final long serialVersionUID = 300L;
	
	private BankFacade myBank = null;
	private Client newClient;
	private String userCde;
    private String userPwd;
    private String profile;
	private String clientNumber;

	private String lastname;
    private String firstname;
    private String address;
    

	public NewClientController() {
		this.myBank = new BankFacade();
	}

	public String getUserCde() {
		return userCde;
	}

	public void setUserCde(String userCde) {
		this.userCde = userCde;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	
	public Client getClient() {
		return newClient;
	}

	public void setClient(Client client) {
		this.newClient = client;
	}

	private boolean isManager(){
		if(getProfile() != null)
			return true;
		else
			return false;
	}
	
	public String createClient() throws BankException{
		System.out.println("-------> NEW CLIENT");
		newClient = new Client();
		newClient.setClientNumber(this.getClientNumber());
		newClient.setFirstname(getFirstname());
		newClient.setLastname(getLastname());
		newClient.setAddress(getAddress());
		newClient.SetAuthorizations(this.getUserCde(), getUserPwd(), isManager());

		myBank.createNewClient(newClient);
		
		return ActionSupport.SUCCESS;
	}

}
