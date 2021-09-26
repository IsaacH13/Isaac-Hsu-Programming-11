package sample;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    String filename;

    public Group(String line) {
        int commaIndex = line.indexOf(',');
        name = line.substring(0, commaIndex);
        filename = line.substring(commaIndex + 1);
    }

    public Group(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public String toDataLine() {
        String line = name + "," + filename;
        return line;
    }

    public static List<String> convertGroupsToNames(List<Group> groups) {
        List<String> names = new ArrayList<>();
        for (Group group : groups) {
            String groupName = group.getName();
            names.add(groupName);
        }
        return names;
    }

    public String getName() {
        return name;
    }

    public String getFilename() {
        return filename;
    }
}
