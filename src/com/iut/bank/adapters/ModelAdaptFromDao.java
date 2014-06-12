package com.iut.bank.adapters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iut.bank.business.*;
import com.iut.bank.entities.AccountEntity;
import com.iut.bank.entities.BankEntity;
import com.iut.bank.entities.ClientEntity;

/**
 * Created by schuma on 23/05/14.
 */
public class ModelAdaptFromDao {

    public static Map<String, Client> adaptClients(List<ClientEntity> listToAdapt){
        Map<String, Client> clientsAdapte = new HashMap<String, Client>();
        for (ClientEntity entity : listToAdapt){
            Client client = adaptToClient(entity);
            clientsAdapte.put(client.getClientNumber(), client);
        }
        return clientsAdapte;
    }

    public Map<String, Account> adaptAccounts(List<AccountEntity> listToAdapt){
        Map<String, Account> comptesAdapte = new HashMap<String, Account>();
        for (AccountEntity entity : listToAdapt){
            if(entity.getDiscoveredAuthorised() == 0) {
                AccountNoDiscovered account = new AccountNoDiscovered(entity.getAccountNumber(),
                                                            entity.getBalance() );
                comptesAdapte.put(account.getAccountNumber(), account);
            }
            else{
                AccountWithDiscovered account = new AccountWithDiscovered(entity.getAccountNumber(),
                                                            entity.getBalance(),
                                                            entity.getDiscoveredAuthorised() );
                comptesAdapte.put(account.getAccountNumber(), account);
            }

        }
        return comptesAdapte;
    }
    
    public static Client adaptToClient(ClientEntity entity) {
		Client client = new Client(entity.getIdClient(), entity.getFirstname(), 
								   entity.getName(), entity.getAddress());
		client.SetAuthorizations(entity.getLogin(), entity.getPassword(), 
								 entity.isManager());	
		for (AccountEntity accountEntity : entity.getAccounts()) {
			client.addAccount(adaptToAccount(accountEntity));
		}
		return client;
	}

	/***
	 * 
	 * @param entities
	 * @return
	 */
	public static Account adaptToAccount(AccountEntity entity) {
		Account account = null;
		if (entity.getDiscoveredAuthorised() != 0) {
			account = new AccountWithDiscovered(entity.getAccountNumber(), 
												entity.getBalance(), 
												entity.getDiscoveredAuthorised());
		} else {
			account = new AccountNoDiscovered(entity.getAccountNumber(), 
												   entity.getBalance());	
		}
		return account;
	}

    public static Bank adapToBank(BankEntity entity) {
        Bank bank = new Bank(entity.getBankId(), entity.getBankName());
        bank.setClients(adaptClients(entity.getClients()));
        return bank;
    }
}
