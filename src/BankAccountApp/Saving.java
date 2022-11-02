package BankAccountApp;

public class Saving extends Account{

    // List the properties specific to savings accounts
    private int safetyDepositBoxId;
    private int safetyDepositBoxKey;


    // Constructor to initialize settings for savings account properties
    public Saving(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = 1 + accountNumber;

        setSafetyDepositBox();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
    }

    //List any methods specific to the savings account
    private void setSafetyDepositBox(){
        safetyDepositBoxId = (int)(Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
    }
    @Override
    public void showInfo(){
        System.out.println("Account Type: Saving");
        super.showInfo();
        System.out.println("Safety Deposit Box Id = " + safetyDepositBoxId +
                "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
    }
}
