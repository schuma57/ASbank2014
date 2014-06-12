package com.iut.bank.tests.model;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.iut.bank.business.Account;
import com.iut.bank.business.Bank;
import com.iut.bank.business.Client;
import com.iut.bank.exceptions.BankException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BankTest  {
	private Bank myBank;


	@Before
	public void setUp() throws Exception {
		this.myBank = new Bank(1, "test");
	}

    @Test
    public void testIsNotNull(){
        assertNotNull(myBank);
    }

    @Test
    public void testSoldeCompte(){
        Map<String, Account> accounts = myBank.getAccounts();
        Assert.assertEquals(200.0, accounts.get("100").getBalance(),0);
    }

    @Test
	public void testRetrait() {
    	Map<String, Account> accounts = myBank.getAccounts();
        double soldeDepart = accounts.get("100").getBalance();
        try {
			myBank.debit("100", "1", 100);
		} catch (BankException e) {
		}
        Assert.assertEquals(soldeDepart-100, accounts.get("100").getBalance(), 0);
	}

    @Test
    public void testRetraitOutDiscovered() {
        //Account account = myBank.searchAccount("1", myBank.getAccounts());
        //double soldeDepart = account.getBalance();
        //myBank.debit("1", "100", 800);
        //Assert.assertNotEquals(soldeDepart-800, account.getBalance(), 0);
    }

    @Test
    public void testDeposit() {
     
        Client client = this.myBank.getClients().get("1");
		Assert.assertNotNull(client);
		//double soldeDepart = client.getAccounts().get("100").getBalance();
		try {
			this.myBank.deposit("100", "1", 200);
		} catch (BankException e) {
			System.out.println(e.getMessage());
		}	
		Account account = client.getAccounts().get("100");
		Assert.assertEquals(account.getBalance(), 200+200, 0);
    }

    @Test
    public void testConversionFromEuro(){
        double sommeDepart = 100;
        double resultat = myBank.conversionFromEuro(sommeDepart);
        assertEquals(sommeDepart*5523.69, resultat, 0);
    }

    @Test
    public void testConversionToEuro(){
        double sommeDepart = 1000;
        double resultat = myBank.conversionToEuro(sommeDepart);
        assertEquals(sommeDepart/5523.69, resultat, 0);
    }

}
