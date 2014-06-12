package com.iut.bank.tests.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.iut.bank.business.AccountWithDiscovered;

import static org.junit.Assert.assertNotNull;

/**
 * Created by schuma on 24/05/14.
 */
public class AccountWithDiscoveredTest {
    private AccountWithDiscovered myAccount;

    @Before
    public void setUp(){
        myAccount = new AccountWithDiscovered("B", 300, 100);
    }

    @Test
    public void testSoldeCompte(){
        Assert.assertEquals(300.0, myAccount.getBalance(),0);
    }

    @Test
    public void testAccountIsNotNull() {
        assertNotNull(this.myAccount);
    }

    @Test
    public void testCrediter() {
        double soldeDepart = myAccount.getBalance();
        myAccount.credit(200);
        Assert.assertEquals(soldeDepart + 200, myAccount.getBalance(), 0);
    }

    @Test
    public void testDediter() {
        double soldeDepart = myAccount.getBalance();
        myAccount.debit(400);
        Assert.assertEquals(soldeDepart - 400, myAccount.getBalance(), 0);
    }

    @Test
    public void testDediterOutDiscovered() {
        double soldeDepart = myAccount.getBalance();
        myAccount.debit(500);
        Assert.assertEquals(soldeDepart - 500, myAccount.getBalance() -500 , 0);
    }

}
