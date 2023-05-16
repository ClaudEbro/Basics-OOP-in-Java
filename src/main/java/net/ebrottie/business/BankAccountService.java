package net.ebrottie.business;

import net.ebrottie.exceptions.AccountNotFoundException;
import net.ebrottie.exceptions.BalanceNotSufficientException;
import net.ebrottie.model.BankAccount;

import java.util.List;
import java.util.function.Predicate;

public interface BankAccountService {

    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void credit(String accountId, double amount) throws AccountNotFoundException;
    void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException;
    List<BankAccount> getSavingAccounts();
    List<BankAccount> CurrentAccounts();
    double getTotalBalance();
    List<BankAccount> searchAccounts(Predicate<BankAccount> filter); //Search BankAccounts by filter
}
