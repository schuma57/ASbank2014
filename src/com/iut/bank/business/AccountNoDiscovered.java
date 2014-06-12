package com.iut.bank.business;

public class AccountNoDiscovered extends Account{


    /***
     * AccountWithoutDiscovered
     * @param accountNumber
     * @param balance
     */
    public AccountNoDiscovered(String accountNumber, double balance) {
        super(accountNumber, balance);
        System.out.println("'AccountWithoutDiscovered' has been created ...");
    }

	@Override
	public boolean debit(double amount){
			
		if (this.balance -amount >= 0){
			this.balance -=amount;
            return true;
		}
        else
            return false;
	}
}
