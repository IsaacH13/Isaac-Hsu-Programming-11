public class Student {
    //fields
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNumber;
    private int studentID = 1;

    //constructor
    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNumber = studentID;
        studentID++;
    }

    //method to get first name
    public String getFirstName() {
        return firstName;
    }

    //defines string firstName from parameter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //method to get last name
    public String getLastName() {
        return lastName;
    }

    //defines string last name from parameter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //method to get grade
    public int getGrade() {
        return grade;
    }

    //defines grade from parameter
    public void setGrade(int grade) {
        this.grade = grade;
    }

    //method to get student number
    public int getStudentNumber() {
        return studentNumber;
    }

    //method to print first, last name, grade
    public String toString(){
        return "Name: " + firstName + " " + lastName + " Grade: " + grade;
    }
}
