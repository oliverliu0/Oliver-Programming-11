package com.example.friendbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private ListView<Friend> friendsListView;

    @FXML
    private Label nameDetail;

    @FXML
    private Label emailDetail;

    @FXML
    private Label phoneDetail;

    private ObservableList<Friend> friendsList;

    // Initialize method is automatically called after the FXML is loaded
    @FXML
    public void initialize() {
        friendsList = FXCollections.observableArrayList();
        friendsListView.setItems(friendsList);
    }

    // Method to handle adding a friend
    @FXML
    public void addFriend() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
            Friend newFriend = new Friend(name, email, phone);
            friendsList.add(newFriend);
            clearFields();
        }
    }

    // Method to show friend details when selected in the list
    @FXML
    public void showFriendDetails() {
        Friend selectedFriend = friendsListView.getSelectionModel().getSelectedItem();
        if (selectedFriend != null) {
            nameDetail.setText(selectedFriend.getName());
            emailDetail.setText(selectedFriend.getEmail());
            phoneDetail.setText(selectedFriend.getPhone());
        }
    }
    public void deleteFriend() {
        Friend selectedFriend = friendsListView.getSelectionModel().getSelectedItem();
        if (selectedFriend != null) {
            friendsList.remove(selectedFriend);
            clearDetails();
        }
    }

    // Clear text fields after adding a friend
    private void clearFields() {
        nameField.clear();
        emailField.clear();
        phoneField.clear();
    }
    // Clear the friend details after deleting a friend
    private void clearDetails() {
        nameDetail.setText("");
        emailDetail.setText("");
        phoneDetail.setText("");
    }
}