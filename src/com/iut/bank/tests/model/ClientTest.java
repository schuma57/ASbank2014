package com.iut.bank.tests.model;

import org.junit.Before;
import org.junit.Test;

import com.iut.bank.business.AccountNoDiscovered;
import com.iut.bank.business.AccountWithDiscovered;
import com.iut.bank.business.Client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by schuma on 23/05/14.
 */
public class ClientTest {
    private Client myClient;

    @Before
    public void setUp(){
        myClient = new Client();
    }

    @Test
    public void testClientIsNotNull() {
        assertNotNull(this.myClient);
    }

    @Test
    public void testGetAccountsIsNotNull() {
        assertNotNull(this.myClient.getAccounts());
    }

    public void testClientAddAccountWithoutDiscovered() {
        myClient.addAccount(new AccountNoDiscovered("FR14", 500));
        assertEquals(1, myClient.getAccounts().size());
    }

    public void testClientAddAccountWithDiscovered() {
        myClient.addAccount(new AccountWithDiscovered("FR1477", 500, 300));
        assertEquals(1, this.myClient.getAccounts().size());
    }
}
