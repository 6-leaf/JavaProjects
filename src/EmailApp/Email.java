package EmailApp;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastname;
    private String email;
    private String password;
    private int passLength = 16;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "anycompany.com";

    // Constructor to receive first name and last name
    public Email(String firstName, String lastname){
        this.firstName = firstName;
        this.lastname = lastname;

        // Call a method for asking department, return department

        this.department = setDepartment();

        // Call a method returns random password

        this.password = randomPass(passLength);
        System.out.println("Your password is = " + password);

        //Combine elements to generate email
        if (department.equals("")){
            email = firstName.toLowerCase() + "." + lastname.toLowerCase() + "@" + companySuffix;
        }else {
            email = firstName.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
        }
    }

    // Ask for department
    private String setDepartment(){
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department Code: ");
        Scanner scan = new Scanner(System.in);
        int depChoice = scan.nextInt();
        String dep = null;
        switch (depChoice){
            case 1 : dep = "sales";break;
            case 2 : dep = "dev";break;
            case 3 : dep = "acct";break;
            case 0 : dep = "";break;
        }
        return dep;
    }

    // Generate random password

    private String randomPass(int length){
        char [] password = new char[length];
        for (int i = 0; i < password.length; i++) {
            Random rnd = new Random();
            password[i] = (char) rnd.nextInt(33, 126);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity){this.mailboxCapacity = capacity;}

    // Set the alternate email
    public void setAlternateEmail(String altEmail){this.alternateEmail = altEmail;}

    // Change the password
    public void changePassword(String password){this.password = password;}

    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "Name: " + firstName + " " + lastname +
                "\nEmail: " + email +
                "\nMailbox Capacity : " + mailboxCapacity;
    }

}