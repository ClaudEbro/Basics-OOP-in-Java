package net.ebrottie.business;

import net.ebrottie.model.BankAccount;

public interface Condition <T> { //Functional interface
    boolean test (T o);
}
