package com.iut.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.iut.bank.entities.AccountEntity;
import com.iut.bank.entities.BankEntity;
import com.iut.bank.entities.ClientEntity;
import com.iut.bank.interfaces.IDao;

/**
 * Created by schuma on 23/05/14.
 */
public class Dao implements IDao {
	
	private DataSource dataSource;
	private Connection myConnection;

	
	public Dao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection getMyConnection(){
		if(myConnection == null){
			try {
				myConnection = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return myConnection;
		}
		else
			return myConnection;
	}
	
	@Override
	public BankEntity getBank(int bankNumber) {
		BankEntity bank = null;
		try {
			PreparedStatement statement = getMyConnection().prepareStatement
	        		("SELECT * FROM BANK WHERE BANK.id_bank = ?");
	        statement.setInt(1, bankNumber);
	        ResultSet result = statement.executeQuery();

	        result.next();
	        
	        bank = new BankEntity();
	        bank.setBankId(result.getInt("id_bank"));
	        bank.setBankName(result.getString("name_bank"));
	        bank.setClients(readListClients(bankNumber));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bank;
	}
	
	
    @Override
    public AccountEntity createAccount(String accountNum, String idClient) {
        try {
        	AccountEntity entity = new AccountEntity();
        	entity.setAccountNumber(accountNum);
        	entity.setBalance(0);
        	entity.setDiscoveredAuthorised(0);
        	entity.setNameAccount("Cheque");
        	entity.setIdBank(1);
            PreparedStatement statement = getMyConnection().prepareStatement
                ("INSERT INTO ACCOUNT (id_account, id_client, name_account, balance, overdraft) "
                		+ "VALUES(?, ? , ?, ?, ?)");
            statement.setString(1, accountNum);
            statement.setString(2, idClient);
            statement.setString(3, "Cheque");
            statement.setDouble(4, 0);
            statement.setInt(5, 0);
            statement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public ClientEntity createClient(ClientEntity client) {
        try{
            PreparedStatement statement = getMyConnection().prepareStatement
                ("INSERT INTO CLIENT "
                		+ "(id_client, lastname, firstname, address, login, password, id_bank, id_profile) "
                		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, client.getIdClient());
            statement.setString(2, client.getName());
            statement.setString(3, client.getFirstname());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getLogin());
            statement.setString(6, client.getPassword());
            statement.setInt(7, client.getIdBanque());
            if(client.isManager())
            	statement.setInt(8, 2);
            else
            	statement.setInt(8, 1);
            
            statement.executeUpdate();
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ClientEntity> readListClients(int idBank) {
        List<ClientEntity> clients = new ArrayList<ClientEntity>();

        try{
            PreparedStatement statement = getMyConnection().prepareStatement
                ("SELECT * FROM BANK, CLIENT WHERE BANK.id_bank = CLIENT.id_bank AND BANK.id_bank = ?");
            statement.setInt(1, idBank);
            ResultSet result = statement.executeQuery();

            while(result.next()){
            	ClientEntity client = new ClientEntity();
            	client.setIdClient(result.getString("id_client"));
            	client.setName(result.getString("lastname"));
            	client.setFirstname(result.getString("firstname"));
            	client.setAddress(result.getString("address"));
            	client.setLogin(result.getString("login"));
            	client.setPassword(result.getString("password"));
            	client.setIdBanque(result.getInt("id_bank"));
            	client.setManager(result.getInt("id_profile"));
            	client.setAccounts(readListAccountsForClient(client.getIdClient()));
            	
            	clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return clients;
    }

    @Override
    public List<AccountEntity> readListAccounts(int idBank) {
        List<AccountEntity> accounts = new ArrayList<AccountEntity>();

        try{
            PreparedStatement statement = getMyConnection().prepareStatement
                ("SELECT * FROM ACCOUNT, CLIENT WHERE CLIENT.id_client=ACCOUNT.id_client AND id_bank = ?");
            statement.setInt(1, idBank);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
            	AccountEntity account = new AccountEntity();
            	account.setAccountNumber(result.getString("id_account"));
            	account.setNameAccount(result.getString("name_account"));
            	account.setIdBank(result.getInt("id_bank"));
            	account.setBalance(result.getDouble("balance"));
            	account.setDiscoveredAuthorised(result.getDouble("overdraft"));
            	
                accounts.add(account);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    private List<AccountEntity> readListAccountsForClient(String idClient) {
        List<AccountEntity> accounts = new ArrayList<AccountEntity>();

        try{
            PreparedStatement statement = getMyConnection().prepareStatement
                ("SELECT * FROM ACCOUNT, CLIENT WHERE CLIENT.id_client=ACCOUNT.id_client AND CLIENT.id_client = ?");
            statement.setString(1, idClient);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
            	AccountEntity account = new AccountEntity();
            	account.setAccountNumber(result.getString("id_account"));
            	account.setNameAccount(result.getString("name_account"));
            	account.setIdBank(result.getInt("id_bank"));
            	account.setBalance(result.getDouble("balance"));
            	account.setDiscoveredAuthorised(result.getDouble("overdraft"));
            	
                accounts.add(account);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }
    
    @Override
    public void updateAccount(AccountEntity account) {
         try{
            PreparedStatement statement = getMyConnection().prepareStatement
            ("UPDATE ACCOUNT SET balance=? WHERE id_account=?");
            statement.setDouble(1, account.getBalance());
            //statement.setDouble(2, account.getDiscoveredAuthorised());
            statement.setString(2, account.getAccountNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient(int idClient, String nom, String prenom) {
        try{
            PreparedStatement statement = getMyConnection().prepareStatement
            ("UPDATE CLIENT SET lastname = ?, firstname = ? WHERE id_client = ?");
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setInt(3, idClient);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(String idAccount) {
        try{
            PreparedStatement statement = getMyConnection().prepareStatement
            ("DELETE FROM ACCOUNT WHERE id_account = ?");
            statement.setString(1, idAccount);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(String idClient) {
        try{
            PreparedStatement statement = getMyConnection().prepareStatement
            ("DELETE FROM CLIENT WHERE id_client = ?");
            statement.setString(1, idClient);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
