package com.iut.bank.tests.controler;


import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import com.iut.bank.controller.BankController;


/**
 * Created by schuma on 23/05/14.
 */
public class BankControllerTest {
    private BankController myController;

    @Before
    public void setUp() {
        this.myController = new BankController();
    }

    @Test
    public void testControleurIsNotNull() {
        assertNotNull(this.myController);
    }

}
