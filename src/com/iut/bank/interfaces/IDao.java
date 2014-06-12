package com.iut.bank.interfaces;

import java.util.List;

import com.iut.bank.entities.BankEntity;
import com.iut.bank.entities.AccountEntity;
import com.iut.bank.entities.ClientEntity;

/**
 * Created by schuma on 23/05/14.
 */
public interface IDao {
	public BankEntity getBank(int bankNumber);
	
    public AccountEntity createAccount(String numCompte, String idClient);
    public ClientEntity createClient(ClientEntity client);

    public List<ClientEntity> readListClients(int idBanque);
    public List<AccountEntity> readListAccounts(int idBanque);

    void updateAccount(AccountEntity account);
    void updateClient(int idCLient, String nom, String prenom);

    void deleteAccount(String idAccount);
    void deleteClient(String idClient);
}
