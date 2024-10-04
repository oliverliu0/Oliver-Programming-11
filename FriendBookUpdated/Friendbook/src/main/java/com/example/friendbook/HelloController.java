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
    // Requires: for three text fields, they cannot be left blank. For name, it can only be characters from a-z or A-Z.
    //           for email address, it must follow the format of character + @ + some character after "@" sign.
    //           for phone number, it must be a 10 digit phone number.
    // Modifies: Add new friend instance into our array list of friends.
    // Effects: we will check whether the name, email, and phone number are in the correct format.
    //          if so, the instance of the friend class will be added to the listview and display the name of this instance.
    @FXML
    public void addFriend() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        // Check if any field is empty
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            System.out.println("You need to fill all the text fields");
            return;  // Stop execution if any field is empty
        }

        // Check for duplicate email or phone number
        boolean isDuplicate = friendsList.stream()
                .anyMatch(friend -> friend.getEmail().equals(email) || friend.getPhone().equals(phone));
        if (isDuplicate) {
            System.out.println("There's already a duplicated email or phone number");
            return;  // Stop execution if duplicate is found
        }

        // Validate email format
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Wrong email format");
            return;  // Stop execution for invalid email
        }

        // Validate phone number format (ensure it's 10 digits)
        if (!phone.matches("\\d{10}")) {
            System.out.println("Invalid phone number, must be 10 digits");
            return;  // Stop execution for invalid phone number
        }

        // Validate name (only letters and spaces allowed)
        if (!name.matches("[A-Za-z ]+")) {
            System.out.println("Invalid Name, use letters from A-Z and spaces only");
            return;  // Stop execution for invalid name
        }

        // All validations passed, create a new friend and add to the list
        Friend newFriend = new Friend(name, email, phone);
        friendsList.add(newFriend);
        System.out.println("Friend successfully added.");
        clearFields();  // Clear input fields after adding the friend
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
    // Requires: there must be friends in the listview and it should be selected.
    // Modifies: friendslist and friendsListView
    // Effects: remove a friend from the listview and array list of friends.
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