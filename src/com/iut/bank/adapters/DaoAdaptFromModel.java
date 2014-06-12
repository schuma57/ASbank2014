package com.iut.bank.adapters;


import com.iut.bank.business.Account;
import com.iut.bank.business.AccountWithDiscovered;
import com.iut.bank.business.Client;
import com.iut.bank.entities.AccountEntity;
import com.iut.bank.entities.ClientEntity;

public class DaoAdaptFromModel {
	
	public static AccountEntity adaptAccount(Account accountToAdapt){
		AccountEntity accountAdapte = new AccountEntity();
	    accountAdapte.setAccountNumber(accountToAdapt.getAccountNumber());
	    accountAdapte.setNameAccount(accountToAdapt.getAccountName());
	    accountAdapte.setIdBank(1);
	    accountAdapte.setBalance(accountToAdapt.getBalance());
	            
	    if(accountToAdapt.getClass().equals(new AccountWithDiscovered("1",200,100).getClass() )){
	        AccountWithDiscovered temp = (AccountWithDiscovered) accountToAdapt;
	        accountAdapte.setDiscoveredAuthorised(temp.getDiscoveredAuthorised());
	    }
	    else
	    	accountAdapte.setDiscoveredAuthorised(0);

	    return accountAdapte;
	}
	
	public static ClientEntity adaptClient(Client clientToAdapt){
		ClientEntity clientAdapte = new ClientEntity();
	    clientAdapte.setIdClient(clientToAdapt.getClientNumber());
	    clientAdapte.setName(clientToAdapt.getLastname());
	    clientAdapte.setFirstname(clientToAdapt.getFirstname());
	    clientAdapte.setAddress(clientToAdapt.getAddress());
	    clientAdapte.setLogin(clientToAdapt.getUserCde());
	    clientAdapte.setPassword(clientToAdapt.getUserPwd());
	    clientAdapte.setIdBanque(1);
	    if(clientToAdapt.isManager())
	    	clientAdapte.setManager(2);
	    else
	    	clientAdapte.setManager(1);

	    return clientAdapte;
	}
	
}
