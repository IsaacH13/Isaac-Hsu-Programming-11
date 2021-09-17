public class Main {
    public static void main(String[] args) {
        //establish school
        School school = new School("dwane johnson's school of wrestling", "5000", "Pacific Ocean");

        //create original student list (fill the student arraylist)
        school.addStudent(new Student("john", "bena", 2));
        school.addStudent(new Student("john", "cena", 3));
        school.addStudent(new Student("john", "dena", 4));
        school.addStudent(new Student("john", "eena", 5));
        school.addStudent(new Student("john", "fena", 6));
        school.addStudent(new Student("john", "gena", 7));
        school.addStudent(new Student("john", "jena", 8));
        school.addStudent(new Student("john", "kena", 9));
        school.addStudent(new Student("john", "lena", 10));
        school.addStudent(new Student("john", "mena", 11));

        //create the original teacher list (fill the teacher arraylist)
        school.addTeacher(new Teacher("dwane the rock", "johnson", "wrestling"));
        school.addTeacher(new Teacher("dwane the glock", "johnson", "also wrestling"));
        school.addTeacher(new Teacher("dwane the sock", "johnson", "also wrestling"));

        //recall the method that prints the student/teacher list
        System.out.println("***ORIGINAL STUDENT LIST***");
        school.studentList();

        System.out.println("\n***ORIGINAL TEACHER LIST***");
        school.teacherList();

        //delete two students and a teacher
        school.delStudent("eena");
        school.delStudent("kena");
        school.delTeacher("dwane the sock");

        //reprint the lines
        System.out.println("\n***UPDATED STUDENT LIST***");
        school.studentList();
        System.out.println("\n***UPDATED TEACHER LIST***");
        school.teacherList();
    }
}