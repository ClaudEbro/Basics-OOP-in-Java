package net.ebrottie;

import net.ebrottie.business.BankAccountService;
import net.ebrottie.business.BankAccountServiceImpl;
import net.ebrottie.exceptions.AccountNotFoundException;
import net.ebrottie.model.BankAccount;
import net.ebrottie.model.CurrentAccount;
import net.ebrottie.model.SavingAccount;

import java.util.List;
import java.util.function.Consumer;

//To run the business layer
public class Application {

    public static void main(String[] args) {
        //To create a BankAccount
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addBankAccount(new CurrentAccount("XOF",45000,1000));
        bankAccountService.addBankAccount(new SavingAccount("XOF",5000,3.5));

        BankAccount bankAccount3 = new CurrentAccount("XOF",50000,2000);
        bankAccount3.setAccountId("CC1");
        bankAccountService.addBankAccount(bankAccount3);
        
        //To display all BankAccounts created
        List<BankAccount> allAccounts = bankAccountService.getAllAccounts();

        //To Browse all BankAccounts and display them

        /* Fisrt way
        for (int i=0; i < allAccounts.size(); i++){
            System.out.println(allAccounts.get(i).toString());
        }*/

        /*Second way : with generic collection

        for (BankAccount bankAccount:allAccounts){
            System.out.println(bankAccount.toString());
        }*/

        //Third way : by using API Stream
        //Before Java 8
        /*allAccounts.forEach(new Consumer<BankAccount>() {
            @Override
            public void accept(BankAccount account) {
                System.out.println(account.toString());
            }
        });

        //With Java 8 by lambda expression
        allAccounts.forEach(account -> System.out.println(account.toString()));*/

        //Another way after Java 8
        System.out.println("******** All BankAccounts *********");
        allAccounts.forEach(System.out::println);


        //To search a BankAccount
        BankAccount accountById = null;

        try {
            accountById = bankAccountService.getAccountById("CC3");
            System.out.println("******** BankAccount searched ********");
            System.out.println(accountById.toString());
        }
        catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("******** Running Program ********");

    }
}
