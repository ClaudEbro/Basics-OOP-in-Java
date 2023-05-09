package net.ebrottie;

import net.ebrottie.model.BankAccount;

public class App {

    public static void main(String[] args) {
        BankAccount account1 = null;
        account1 = new BankAccount();
        //account1.setAccountId("722-15"); //due to generating automatically the account ID
        account1.setCurrency("XOF");
        account1.setBalance(7900000);

        printAccount(account1);

        //Create a new account with the constructor's overload
        BankAccount account2 = new BankAccount("XOF", 3000);
        printAccount(account2);

    }

    public static void printAccount(BankAccount account){

        System.out.println("**********************************");

        System.out.println("Account ID = "+account.getAccountId());
        System.out.println("Balance = "+account.getBalance());
        System.out.println("Status = "+account.getStatus());
        System.out.println("Currency = "+account.getCurrency());
        System.out.println(account.toString());
        System.out.println(account.hashCode());
        System.out.println(account.equals(account));

        System.out.println("**********************************");
    }
}
