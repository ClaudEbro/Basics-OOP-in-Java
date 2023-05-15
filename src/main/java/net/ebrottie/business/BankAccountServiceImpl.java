package net.ebrottie.business;

import net.ebrottie.exceptions.AccountNotFoundException;
import net.ebrottie.exceptions.BalanceNotSufficientException;
import net.ebrottie.model.AccountStatus;
import net.ebrottie.model.BankAccount;
import net.ebrottie.model.CurrentAccount;
import net.ebrottie.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class BankAccountServiceImpl implements BankAccountService{

    private List<BankAccount> bankAccountList = new ArrayList<>(); //I define a generic collection of BankAccounts to store them

    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountList;
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountNotFoundException {

        //Declarative Approach
        return bankAccountList
                .stream()
                .filter(acc -> acc.getAccountId().equals(id))
                .findFirst()
                .orElseThrow(()->new AccountNotFoundException(String.format("BankAccount %s not found",id)));

        //Imperative Approach
        /*for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }
        throw new AccountNotFoundException("BankAccount not found");*/
    }

    @Override
    public void addRandomData(int size) {
        AccountStatus[] values = AccountStatus.values();
        Random random = new Random();
        for (int i=0; i<size; i++){
            BankAccount bankAccount;
            if (Math.random() > 0.5){
                bankAccount = new CurrentAccount(Math.random() > 0.5?"XOF":"USD",Math.random()*1000000,Math.random()*50000);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            } else {
                bankAccount = new SavingAccount(Math.random() > 0.5?"XOF":"USD",Math.random()*1000000,3+Math.random()*7);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }

            bankAccountList.add(bankAccount);
        }
    }

    @Override
    public void credit(String accountId, double amount) throws AccountNotFoundException {
        BankAccount accountById = getAccountById(accountId);
        accountById.setBalance(accountById.getBalance()+amount);
    }

    @Override
    public void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        BankAccount accountById = getAccountById(accountId);
        if (amount > accountById.getBalance()) throw new BalanceNotSufficientException("Balance not sufficient");
        accountById.setBalance(accountById.getBalance()-amount);
    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        debit(accountSource, amount);
        credit(accountDestination, amount);
    }

    @Override
    public List<BankAccount> getSavingAccounts() {
        return null;
    }

    @Override
    public List<BankAccount> CurrentAccounts() {
        return null;
    }

    @Override
    public double getTotalBalance() {
        return 0;
    }
}
