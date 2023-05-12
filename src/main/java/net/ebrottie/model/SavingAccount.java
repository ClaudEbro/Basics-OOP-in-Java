package net.ebrottie.model;

public class SavingAccount extends BankAccount{

    private double interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(String currency, double initialBalance, double interestRate) {
        super(currency, initialBalance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Saving Account, Interest rate ="+interestRate+","+super.toString();
    }

    @Override
    public String getType() {
        return "SAVING_ACCOUNT";
    }
}
