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

    //method to add a friend to the list 'friendList'
    public void addFriend(ActionEvent actionEvent) {
        String name = textGetName.getText();
        int age = Integer.parseInt(textGetAge.getText());
        String gender = textGetGender.getText();
        Friend temp = new Friend(name, age, gender);
        friendList.getItems().add(temp);
        //blanks the text fields after friend has been added
        textGetName.clear();
        textGetAge.clear();
        textGetGender.clear();
    }

    //displays the friend in the list when clicked
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        //gets selected item (friend) in the list
        temp = friendList.getSelectionModel().getSelectedItem();
        //sets the different parameters to what was specified in addFriend
        lblName.setText(temp.name);
        lblAge.setText(Integer.toString(temp.getAge()));
        lblGender.setText(temp.gender);
        //disables the button to not break the program
        btnDel.setDisable(false);
    }

    public void delFriend(ActionEvent actionEvent) {
        Friend temp;
        //gets selected item (friend) in the list
        temp = friendList.getSelectionModel().getSelectedItem();
        //removes it
        friendList.getItems().remove(temp);
        //blanks all of the text labels
        lblName.setText("");
        lblAge.setText("");
        lblGender.setText("");
        //checks to see if friendList is empty; if it is, disables the "delete friend" button to not break the program
        if(friendList.getSelectionModel().getSelectedItem() == null){
            btnDel.setDisable(true);
        }
    }
}
