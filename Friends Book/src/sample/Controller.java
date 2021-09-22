package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    public ListView<Friend> friendList = new ListView<>();
    public Button btnDel;
    public Label lblName;
    public Label lblAge;
    public Label lblGender;
    public TextField textGetName;
    public TextField textGetAge;
    public TextField textGetGender;

    public void addFriend(ActionEvent actionEvent) {
        String name = textGetName.getText();
        int age = Integer.parseInt(textGetAge.getText());
        String gender = textGetGender.getText();
        Friend temp = new Friend(name, age, gender);
        friendList.getItems().add(temp);
        textGetName.clear();
        textGetAge.clear();
        textGetGender.clear();
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        lblName.setText(temp.name);
        lblAge.setText(Integer.toString(temp.getAge()));
        lblGender.setText(temp.gender);
        btnDel.setDisable(false);
    }

    public void delFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(temp);
        lblName.setText("");
        lblAge.setText("");
        lblGender.setText("");
        if(friendList.getSelectionModel().getSelectedItem() == null){
            btnDel.setDisable(true);
        }
    }
}
