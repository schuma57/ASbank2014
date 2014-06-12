package com.iut.bank.factories;

import com.iut.bank.interfaces.IDao;

/**
 * Created by schuma on 23/05/14.
 */
public class BackEndFactory {
    
private IDao myDb;
	
	public IDao getMyDb() {
		return this.myDb;
	}
	
	public void setMyDb(IDao myDb) {
		this.myDb = myDb;
	}

	/***
	 * Constructor :
	 */
	public BackEndFactory() {
		// Empty :
	}
	
	/***
	 * Injection with spring :
	 * @param myDaoIn
	 */
	public BackEndFactory(IDao myDaoIn) {
		System.out.println("Backend factory with DAO has been created ... ");
		this.myDb = myDaoIn;
	}
}
