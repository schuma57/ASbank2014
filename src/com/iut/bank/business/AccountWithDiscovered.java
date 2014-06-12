package com.iut.bank.business;

public class AccountWithDiscovered extends Account {

	private double discoveredAuthorised;

    /***
     * AccountWithDiscovered
     * @param accountNumber
     * @param balance
     * @param discoveredAuthorised
     */
    public AccountWithDiscovered(String accountNumber, double balance, double discoveredAuthorised) {
        super(accountNumber, balance);
        System.out.println("'AccountWithDiscovered' has been created ...");
        System.out.println("Maximum amount is " + discoveredAuthorised);
        this.discoveredAuthorised = discoveredAuthorised;
    }


    public double getDiscoveredAuthorised() {
        return discoveredAuthorised;
    }

    public void setDiscoveredAuthorised(double discoveredAuthorised) {
        this.discoveredAuthorised = discoveredAuthorised;
    }

    @Override
	public boolean debit(double amount){
		
		if (this.balance -amount >= -discoveredAuthorised){
				this.balance -=amount;
            return true;
		}
        else
            return false;
	}
	
}
