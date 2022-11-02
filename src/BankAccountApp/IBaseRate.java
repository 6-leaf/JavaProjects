package BankAccountApp;

public interface IBaseRate {

    // Write a method that returns to base rate
    default double getBaseRate(){
        return 2.5;
    }


}
