package by.incubator;

import java.util.Scanner;

public class StudentsMain {

    public static void main(String[] args) {
        int size;
        String lastName;
        String firstName;
        int averageGrade;
        Scanner in = new Scanner(System.in);
        StudentsLogic stLogic = new StudentsLogic();

        do {
            System.out.print("Input amount of students (the value should be natural):");
            size = Integer.parseInt(in.nextLine());
        } while (size < 1);

        Student[] students = new Student[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Input student's last name: ");
            lastName = in.nextLine();

            System.out.print("Input student's first name: ");
            firstName = in.nextLine();

            System.out.print("Input student's average grade: ");
            averageGrade = Integer.parseInt(in.nextLine());

            students[i] = new Student(lastName, firstName, averageGrade);
        }

        System.out.println();
    }
}
