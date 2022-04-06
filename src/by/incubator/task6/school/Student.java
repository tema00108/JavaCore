package by.incubator.task6.school;

public class Student {
    private static int counterOfStudents = 0;
    private static final int schoolNumber = 1;

    private final String lastName;
    private final String firstName;
    private double averageGrade;

    public Student(String lastName, String firstName, double averageGrade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.averageGrade = averageGrade;

        counterOfStudents++;

        System.out.println("\nDefault constructor execution - " + counterOfStudents + '\n');
    }

    public static int getCounterOfStudents() {
        return counterOfStudents;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String toString() {
        return lastName + " " + firstName + " " + averageGrade;
    }
}