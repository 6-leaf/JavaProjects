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
        index++;
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
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

    public void compound(){
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    // List common methods
    public void showInfo() {
        System.out.println("Name: " + name +
                "\nSSN: " + sSN +
                "\nAccount Number: " + accountNumber +
                "\nBalance: $" + balance +
                "\nRate: %" + rate);
    }

    // List common methods - transactions
    public void deposit(double amount){
        balance += amount;
        System.out.println("Depositing: $" + amount);
        printBalance();
    }
    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdrawing: $" + amount);
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }
    public void printBalance(){
        System.out.println("Your balance is: $" + balance);
    }
}