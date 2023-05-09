package net.ebrottie;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.ebrottie.model.BankAccount;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App2 {
    public static void main(String[] args) throws JsonProcessingException {

        //Filling the BankAccount with Objects' list

        //With a table
        System.out.println("************** Table ****************");
        BankAccount[] accounts = new BankAccount[4];
        accounts[0] = new BankAccount("USD", 5400);
        accounts[1] = new BankAccount("XOF", 1290);
        accounts[2] = new BankAccount("USD", 3200);
        accounts[3] = new BankAccount("XOF", 5400);

        for(BankAccount acc:accounts){
            System.out.println(acc.getBalance());
        }

        //With a List Collection
        System.out.println("************** List ****************");
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(new BankAccount("XOF", 5400));
        bankAccountList.add(new BankAccount("USD", 4300));
        bankAccountList.add(new BankAccount("XOF", 5400));
        bankAccountList.add(new BankAccount("USD", 234));
        bankAccountList.add(new BankAccount("USD", 65));

        for(BankAccount acc:bankAccountList){
            System.out.println(acc.getBalance());
        }

        //With a Map Collection
        System.out.println("************** Map ****************");
        Map<String, BankAccount> bankAccountMap = new HashMap<>();
        bankAccountMap.put("cc1", new BankAccount("XOF", 5400));
        bankAccountMap.put("cc2", new BankAccount("USD", 800));
        bankAccountMap.put("cc3", new BankAccount("USD", 700));
        bankAccountMap.put("cc4", new BankAccount("XOF", 3500));

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
