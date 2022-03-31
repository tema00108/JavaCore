package by.incubator;

public class Student {
    private static int counterOfStudents = 0;

    private final int schoolNumber = 1;

    private String lastName;
    private String firstName;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
