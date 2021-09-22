package sample;

public class Friend {
    public String name;
    private int age;
    public String gender;

    Friend(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //getters and setters
    public int getAge(){
        return age;
    }

    public String toString(){
        return name;
    }
}
