package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    File groupsFile = new File("FriendGroups.txt");

    public List<Group> loadGroups() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(groupsFile));
        List<Group> groups = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            Group group = new Group(line);
            groups.add(group);
        }
        br.close();
        return groups;
    }

    public Group findGroupByName(String groupName) throws IOException {
        List<Group> groups = loadGroups();
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    public List<Friend> getFriends(Group group) throws IOException {
        List<Friend> friends = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(group.getFilename()));
        String line;
        while ((line = br.readLine()) != null) {
            Friend friend = new Friend(line);
            friends.add(friend);
        }
        return friends;
    }

    public void addGroupInTxt(Group group) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(groupsFile, true));
        bw.write(group.toDataLine() + "\n");
        bw.flush();
        bw.close();
    }

    public void putFriendInGroup(Friend friend, Group group) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(group.getFilename()), true));
        bw.write(friend.toDataLine() + "\n");
        bw.flush();
        bw.close();
    }
}
