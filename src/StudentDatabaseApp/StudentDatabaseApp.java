package StudentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        // Ask how many new students we want to add
        System.out.print("How many of new students to enroll: ");
        Scanner scan = new Scanner(System.in);
        int numberOfStudents = scan.nextInt();
        Student[] students = new Student[numberOfStudents];

        //  Create n number of new students
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            System.out.println(students[i].showStatus());
        }
    }
}