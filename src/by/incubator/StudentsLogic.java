package by.incubator;

public class StudentsLogic {

    public StudentsLogic() {

    }

    public void display(Student student) {
        System.out.println(student.getLastName() + " " + student.getFirstName()
                + " " + student.getAverageGrade());
    }

    public double countAverageGrade(Student... students) {
        int averageGrade = 0;

        for (int i = 0; i < students.length; i++) {
            averageGrade += students[i].getAverageGrade() / students.length;
        }

        return averageGrade;
    }
}
