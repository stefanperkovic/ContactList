/** Student.java
 * Stefan Perkovic January, 20 2023
 * A subclass of Person that represents a Student and their common attributes
 */

public class Student extends Person {
    private int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + " Grade : " + grade;
    }
}
