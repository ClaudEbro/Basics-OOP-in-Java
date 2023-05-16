package net.ebrottie;

import net.ebrottie.business.BankAccountService;
import net.ebrottie.business.BankAccountServiceImpl;
import net.ebrottie.business.Condition;
import net.ebrottie.exceptions.AccountNotFoundException;
import net.ebrottie.exceptions.BalanceNotSufficientException;
import net.ebrottie.model.BankAccount;
import net.ebrottie.model.CurrentAccount;
import net.ebrottie.model.SavingAccount;
import net.ebrottie.utils.DataTranformationUtils;

import java.util.List;

//To populate BankAccount and test other implemented methods
public class App3 {

    public static void main(String[] args) {

        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addRandomData(20);

        //To display the BankAccounts
        //bankAccountService.getAllAccounts().forEach(account -> System.out.println(DataTranformationUtils.toJson(account)));

        //or use this
        /*bankAccountService.getAllAccounts()
                .stream()
                .map(DataTranformationUtils::toJson)
                .forEach(System.out::println);*/

        //Adding a BankAccount
        BankAccount bankAccount1 = new CurrentAccount("XOF",32000,1000);
        bankAccount1.setAccountId("CC1");

        BankAccount bankAccount2 = new SavingAccount("XOF",100,3.2);
        bankAccount2.setAccountId("CC2");

        bankAccountService.addBankAccount(bankAccount1);
        bankAccountService.addBankAccount(bankAccount2);

        //To search the BankAccount added
        /*try {
            BankAccount bankAccount = bankAccountService.getAccountById("CC2");
            System.out.println(DataTranformationUtils.toJson(bankAccount));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }*/

        //To test debit, credit and transfer
        /* Debit Operation
        try {
            BankAccount bankAccount = bankAccountService.getAccountById("CC1");
            System.out.println("========= Before Operation ===========");
            System.out.println(DataTranformationUtils.toJson(bankAccount));
            bankAccountService.debit(bankAccount.getAccountId(),5000);
            System.out.println("========= After Operation ===========");
            System.out.println(DataTranformationUtils.toJson(bankAccount));

        } catch (AccountNotFoundException | BalanceNotSufficientException e) {
            System.out.println(e.getMessage());
        }*/

        //Transfer Operation
        try {
            BankAccount acc1 = bankAccountService.getAccountById("CC1");
            BankAccount acc2 = bankAccountService.getAccountById("CC2");

            System.out.println("========= Before Operation ===========");
            System.out.println(DataTranformationUtils.toJson(acc1));
            System.out.println(DataTranformationUtils.toJson(acc2));

            bankAccountService.debit(acc1.getAccountId(),2000);

            System.out.println("========= After Operation ===========");
            System.out.println(DataTranformationUtils.toJson(acc1));

            bankAccountService.transfer(acc1.getAccountId(),acc2.getAccountId(),3000);

            System.out.println("========= After Transfer ===========");
            System.out.println(DataTranformationUtils.toJson(acc1));
            System.out.println(DataTranformationUtils.toJson(acc2));

        } catch (AccountNotFoundException | BalanceNotSufficientException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("========= All SavingAccounts ===========");
        bankAccountService.getSavingAccounts()
                .stream()
                .map(DataTranformationUtils::toJson)
                .forEach(System.out::println);

        System.out.println("========= Total Balance ===========");
        System.out.println("TOTAL BALANCE = "+bankAccountService.getTotalBalance());


        System.out.println("========= Search BankAccounts by conditions ===========");
        List<BankAccount> bankAccountList = bankAccountService.searchAccounts(bankAccount -> (bankAccount.getBalance() > 10000));
        bankAccountList.stream().map(DataTranformationUtils::toJson).forEach(System.out::println);
    }
}
