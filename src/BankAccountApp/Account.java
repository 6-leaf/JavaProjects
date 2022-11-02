package BankAccountApp;

public abstract class Account implements IBaseRate{
    // List common properties for savings and checking

    String name;
    String sSN;
    double balance;
    static int index = 10000;
    String accountNumber;
    double rate;

    //Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        //Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }
    public abstract void setRate();

    private String setAccountNumber(){
        String lastTwoOdSsn = sSN.substring(sSN.length()-2);
        int uniqueId = index;
        int rndNumber = (int )(Math.random() * Math.pow(10, 3));
        return lastTwoOdSsn + uniqueId + rndNumber;
    }

    // List common methods
    public void showInfo() {
        System.out.println("Name: " + name +
                "\nSSN: " + sSN +
                "\nAccount Number: " + accountNumber +
                "\nBalance: " + balance +
                "\nRate: %" + rate);
    }
    public void deposit(double amount){
        balance += amount;
        System.out.println("Depositing: $ = " + amount);
    }
    public void withdraw(double amount){
        balance -= amount;
    }
    public void transfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transferring $ = " + amount + " to " + toWhere);
    }
}