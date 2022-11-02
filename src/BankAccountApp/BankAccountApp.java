package BankAccountApp;

import javax.swing.text.Utilities;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        // Read a CSV file then create new accounts on that data
        String file = "D:\\MEGA\\JavaProjects_Files\\NewBankAccounts.csv";

        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equalsIgnoreCase("Savings")) {
                accounts.add(new Saving(name, sSN, initDeposit));
            } else if (accountType.equalsIgnoreCase("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("Error reading account type");
            }
        }

        for (Account acc : accounts) {
            acc.showInfo();
            System.out.println("==============================");
        }
    }
}
