package sample;

public class Friend {
    String name;
    int age;
    String gender;

    Friend(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Friend(String line) {
        int indexOfComma = line.indexOf(',');
        name = line.substring(0, indexOfComma);
        line = line.substring(indexOfComma + 1);
        indexOfComma = line.indexOf(',');
        age = Integer.parseInt(line.substring(0, indexOfComma));
        gender = line.substring(indexOfComma + 1);
    }

    public String toDataLine() {
        return name + "," + age + "," + gender;
    }
}
