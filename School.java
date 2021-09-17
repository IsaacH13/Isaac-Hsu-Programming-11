import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<School> courses = new ArrayList();

    //establish fields
    private String name;
    private String age;
    private String location;

    //method to add a teacher
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //method to add a student
    public void addStudent(Student student){
        students.add(student);
    }

    //method uses a loop to delete a specified teacher
    public void delTeacher(String firstName){
        for(int i=0; i<teachers.size(); i++){
            if(teachers.get(i).getFirstName() == firstName){
                teachers.remove(teachers.get(i));
            }
        }
    }

    //method uses a loop to delete a specified student
    public void delStudent(String lastName){
        for(int i=0; i<students.size(); i++){
            if(students.get(i).getLastName() == lastName){
                students.remove(students.get(i));
            }
        }
    }

    //method uses a loop and another method to print all teachers in arraylist teacherList
    public void teacherList(){
        for(int i=0; i<teachers.size(); i++){
            System.out.println(teachers.get(i).toString());
        }
    }

    //method uses a loop and another method to print all students in arraylist studentList
    public void studentList(){
        for(int i=0; i<students.size(); i++){
            System.out.println(students.get(i).toString());
        }
    }

    //constructor
    public School(String name, String age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
