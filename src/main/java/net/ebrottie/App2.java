package net.ebrottie;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.ebrottie.model.BankAccount;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ebrottie.model.CurrentAccount;
import net.ebrottie.model.SavingAccount;

public class App2 {
    public static void main(String[] args) throws JsonProcessingException {

        //Filling the BankAccount with Objects' list

        //With a table
        System.out.println("************** Table ****************");
        BankAccount[] accounts = new BankAccount[4];
        accounts[0] = new CurrentAccount("USD", 5400, 2000);
        accounts[1] = new CurrentAccount("XOF", 1290, 4300);
        accounts[2] = new SavingAccount("USD", 3200, 3.7);
        accounts[3] = new SavingAccount("XOF", 5400, 3.7);

        for(BankAccount acc:accounts){
            /*if (acc instanceof CurrentAccount){
                System.out.println(((CurrentAccount)acc).getType());
            } else if (acc instanceof SavingAccount) {
                System.out.println(((SavingAccount)acc).getType());
            }*/

            System.out.println(acc.getType()); //Introduction of polymorphism

            //To display the interest rate or the overdraft according the type of account
            if (acc instanceof CurrentAccount){
                System.out.println("Overdraft = "+((CurrentAccount)acc).getOverDraft());
            } else if (acc instanceof SavingAccount) {
                System.out.println("Rate = "+((SavingAccount)acc).getInterestRate());
            }
        }

        for (BankAccount acc:accounts){

        }

        //With a List Collection
        System.out.println("************** List ****************");
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(new CurrentAccount("XOF", 5400, 4000));
        bankAccountList.add(new CurrentAccount("USD", 4300, 3800));
        bankAccountList.add(new SavingAccount("XOF", 5400, 3.7));
        bankAccountList.add(new SavingAccount("USD", 234,5));
        bankAccountList.add(new SavingAccount("USD", 65, 3));

        for(BankAccount acc:bankAccountList){
            System.out.println(acc.getBalance());
        }

        //With a Map Collection
        System.out.println("************** Map ****************");
        Map<String, BankAccount> bankAccountMap = new HashMap<>();
        bankAccountMap.put("cc1", new CurrentAccount("XOF", 5400, 2000));
        bankAccountMap.put("cc2", new SavingAccount("USD", 800, 7));
        bankAccountMap.put("cc3", new CurrentAccount("USD", 700, 300));
        bankAccountMap.put("cc4", new SavingAccount("XOF", 3500, 5));

        BankAccount acc = bankAccountMap.get("cc2");
        System.out.println(acc.toString());

        //To browse and display the Map Collection by their keys
        System.out.println("************** Map by key ****************");
        for (String key : bankAccountMap.keySet()){
            System.out.println(bankAccountMap.get(key));
        }

        //To browse and display the Map Collection by their value
        System.out.println("************** Map by value in Json ****************");
        for (BankAccount ba:bankAccountMap.values()){
            System.out.println(toJson(ba));
        }
    }

    //To convert BankAccount data in JSON
    public static String toJson(Object o) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}
