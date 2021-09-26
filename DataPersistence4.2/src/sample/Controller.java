package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class Controller {
    public TextField textGetName;
    public TextField textGetAge;
    public TextField textGetGender;

    public TextField textGetNewGroup;
    public Button btnCreateGroup;
    public ListView<String> groupList;
    public ListView<String> friendList;

    List<Group> groups = null;

    FileManager fileManager = new FileManager();

    public void addFriend(ActionEvent actionEvent) throws IOException {
        String groupName = groupList.getSelectionModel().getSelectedItem();
        Group group = fileManager.findGroupByName(groupName);
        if (group == null) {
            return;
        }
        String name = textGetName.getText();
        int age = Integer.parseInt(textGetAge.getText());
        String gender = textGetGender.getText();
        Friend friend = new Friend(name, age, gender);
        fileManager.putFriendInGroup(friend, group);
        textGetName.clear();
        textGetAge.clear();
        textGetGender.clear();
        displayFriendList(actionEvent);
    }

    public void displayFriendList(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        String groupName = groupList.getSelectionModel().getSelectedItem();
        Group group = fileManager.findGroupByName(groupName);
        if (group == null) {
            return;
        }
        List<Friend> friends = fileManager.getFriends(group);
        for (Friend friend : friends) {
            friendList.getItems().add(friend.toDataLine());
        }
    }

    public void createGroup(ActionEvent actionEvent) throws IOException {
        String groupNameText = textGetNewGroup.getText();
        if (groupNameText != null && !groupNameText.isEmpty()) {
            Group group = new Group(
                    groupNameText,
                    "group." + groupNameText.replaceAll(" ", "") + ".txt"
            );
            fileManager.addGroupInTxt(group);
            textGetNewGroup.clear();
            loadGroups(actionEvent);
        }
    }

    public void loadGroups(ActionEvent actionEvent) throws IOException {
        groupList.getItems().clear();
        groups = fileManager.loadGroups();
        List<String> names = Group.convertGroupsToNames(groups);
        ObservableList<String> observableNames = FXCollections.observableArrayList(names);
        groupList.setItems(observableNames);
    }
}
