package by.incubator.task6.school;

import java.util.Scanner;

public class StudentsMain {

    public static void main(String[] args) {
        int size;
        double averageGrade;

        Scanner in = new Scanner(System.in);
        StudentsLogic stLogic = new StudentsLogic();

        do {
            System.out.print("Input amount of students (the value should be natural): ");
            size = Integer.parseInt(in.nextLine());
        } while (size < 1);

        Student[] students = new Student[size];

        for (int i = 0; i < size; i++) {
            students[i] = stLogic.fullfillStudent();
        }

        averageGrade = stLogic.countAverageGrade(students);
        System.out.printf("%.2f\n", averageGrade);

        for (int i = 0; i < size; i++) {

            if (stLogic.isABadStudent(students[i], averageGrade)) {
                stLogic.display(students[i]);
            }
        }


    }
}

