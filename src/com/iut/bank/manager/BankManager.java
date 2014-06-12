package com.iut.bank.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.iut.bank.business.Account;
import com.iut.bank.business.Bank;
import com.iut.bank.business.Client;
import com.iut.bank.factories.BackEndFactory;
import com.iut.bank.adapters.DaoAdaptFromModel;
import com.iut.bank.adapters.ModelAdaptFromDao;
import com.iut.bank.interfaces.IDao;


public class BankManager {
	
	private IDao myDb = null;
	private static Bank myBank;

	public Bank getMyBank() {
		return myBank;
	}

	/***
	 * 
	 */
	public BankManager() {
		// Connection to the database :
		System.out.println("In the 'BankManager' constructor :");
		BackEndFactory daoFact = (BackEndFactory) (new XmlBeanFactory(
				new ClassPathResource("applicationContext.xml")))
				.getBean("backEndFactory");
		
		// Get the Db :
		System.out.println("Get the dababase : ");
		this.myDb = daoFact.getMyDb();
		if (myBank == null)
			myBank = ModelAdaptFromDao.adapToBank(myDb.getBank(1));
	}

	/**
	 * To known if the person is a client :
	 * 
	 * @param usrCde
	 * @param usrPwd
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Client getCurrentUser(String usrCde, String usrPwd) {
		Iterator iterator = myBank.getClients().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			Client client = (Client) entry.getValue();
			if (usrCde.equals(client.getUserCde())
					&& usrPwd.equals(client.getUserPwd())) {
				System.out.println("Find user : '" + usrCde
						+ "' - is a manager : " + client.isManager());
				System.out.println(client.toString());
				return client;
			}
		}
		System.out.println("User '" + usrCde + "' has not been found !");
		return null;
	}

	/**
	 * Give the accounts belong to the client :
	 * 
	 * @param p
	 * @return
	 */
	public List<Account> getAccountsFromClient(Client p) {
		Client client = myBank.getClients().get(p.getClientNumber());
		return new ArrayList<Account>(client.getAccounts().values());
	}

	public List<Client> getClientsFromBank() {
		return new ArrayList<Client>(myBank.getClients().values());
	}

	
	public List<Account> getAccountsFromBank() {
		return new ArrayList<Account>(myBank.getAccounts().values());
	}

	public Client createNewClientInBank(Client client) {
		myDb.createClient(DaoAdaptFromModel.adaptClient(client));
		myBank.openAccount(client);
		return client;
	}
	
	public void updateAccount(Account account){
		myDb.updateAccount(DaoAdaptFromModel.adaptAccount(account));
	}

}
