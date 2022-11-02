package BankAccountApp;

public class BankAccountApp {
    public static void main(String[] args) {

        Checking chkacct1 = new Checking("Ibrahim", "12345678", 1200);


        Saving svgacct1 = new Saving("Emre", "87654321", 1500);

        chkacct1.showInfo();
        System.out.println("=============================== ");
        svgacct1.showInfo();


        // Read a CSV file then create new accounts on that data


    }
}
