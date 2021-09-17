public class Teacher {
    //fields
    private String firstName;
    private  String lastName;
    private String subject;

    //constructor
    public Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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

    //defines string lastName from parameter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //method to get subject
    public String getSubject() {
        return subject;
    }

    //defines string subject from parameter
    public void setSubject(String subject) {
        this.subject = subject;
    }

    //method to print first, last name, subject
    public String toString(){
        return "Name: " + firstName + " " + lastName + " Subject: " + subject;
    }
}