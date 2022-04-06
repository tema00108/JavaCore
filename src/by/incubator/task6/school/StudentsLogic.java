package by.incubator.task6.school;

import java.util.Scanner;

public class StudentsLogic {

    public StudentsLogic() {

    }

    public Student fullfillStudent() {
        String lastName;
        String firstName;
        double averageGrade;
        Scanner in = new Scanner(System.in);

        System.out.print("Input student's last name: ");
        lastName = in.nextLine();

        System.out.print("Input student's first name: ");
        firstName = in.nextLine();

        do {
            System.out.print("Input student's average grade: ");
            averageGrade = Double.parseDouble(in.nextLine());
        } while (averageGrade < 1.0d || averageGrade > 10.0d);


        return new Student(lastName, firstName, averageGrade);
    }


    public boolean isABadStudent(Student student, double averageGrade) {
        return student.getAverageGrade() < averageGrade;
    }

    public void display(Student student) {
        System.out.println(student.toString());
    }

    public double countAverageGrade(Student... students) {
        double averageGrade = 0;

        for (int i = 0; i < students.length; i++) {
            averageGrade += students[i].getAverageGrade() / students.length;
        }

        return averageGrade;
    }
}
