package StudentDatabaseApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private final ArrayList<String> courses = new ArrayList<>(Arrays.asList("History 101", "Math 101", "English 101", "Chemistry 101", "Computer Science 101"));
    private double  tuitionBalance =0;
    private double costOfCourse = 600;
    private static int id = 1000;

    private ArrayList<String> enrolledCourses = new ArrayList<>();

    // Constructor prompt user enter student's name and year
    public Student(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = scan.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = scan.nextLine();

        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = scan.nextInt();

        setStudentId();
    }

    //Generate an Id
    private String setStudentId(){
        // Class level + id
        id++;
        return this.studentID = gradeYear + "" + id;
    }

    //Enroll in courses
    public void enroll(){
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Please enter course name want to enroll (Q for exit): ");
            String in = scan.nextLine();
            if (courses.contains(in)){
                enrolledCourses.add(in);
                tuitionBalance += costOfCourse;
            } else if (in.equalsIgnoreCase("Q")) {
                break;
            }else{
                System.out.println("This course does not exist!");
            }
        }while(true);
    }

    //View balance
    public void viewBalance(){
        System.out.println("Your balance is $" + tuitionBalance);
    }

    //Pay tuition
    public void payTuition(){
        viewBalance();
        Scanner scan = new Scanner(System.in);
        System.out.print("How much do you want to pay: ");
        double payment = scan.nextDouble();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of: $" + payment);
        viewBalance();
    }

    //Show status
    public String showStatus(){
        return "Name: " + firstName + " " + lastName +
                "\nStudent Id: " + studentID +
                "\nEnrolled courses:\n" + enrolledCourses +
                "\nYour Balance is: $" + tuitionBalance;
    }
}