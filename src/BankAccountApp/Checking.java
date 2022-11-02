package BankAccountApp;

public class Checking extends Account{
    // List the properties specific to checking accounts
    long debitCardNumber;
    int debitCardPin;


    // Constructor to initialize settings for checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = 2 + accountNumber;

        setDebitCard();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }


    //List any methods specific to the checking account
    private void setDebitCard(){
        debitCardNumber = (long)(Math.random() * Math.pow(10, 12));
        debitCardPin = (int)(Math.random() * Math.pow(10, 4));
    }
    @Override
    public void showInfo(){
        System.out.println("Account Type: Saving");
        super.showInfo();
        System.out.println("Debit Card Number = " + debitCardNumber +
                "\nDebit Card pin: " + debitCardPin);
    }

}
