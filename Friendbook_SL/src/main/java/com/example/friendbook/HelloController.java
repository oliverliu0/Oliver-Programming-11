package com.example.friendbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
    private Stage stage;  // Reference to the stage to use FileChooser

    @FXML
    public void initialize() {
        friendsList = FXCollections.observableArrayList();
        friendsListView.setItems(friendsList);
    }

    // Method to handle adding a friend
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

    @FXML
    public void showFriendDetails() {
        Friend selectedFriend = friendsListView.getSelectionModel().getSelectedItem();
        if (selectedFriend != null) {
            nameDetail.setText(selectedFriend.getName());
            emailDetail.setText(selectedFriend.getEmail());
            phoneDetail.setText(selectedFriend.getPhone());
        }
    }

    @FXML
    public void deleteFriend() {
        Friend selectedFriend = friendsListView.getSelectionModel().getSelectedItem();
        if (selectedFriend != null) {
            friendsList.remove(selectedFriend);
            clearDetails();
        }
    }

    // Save friends to a file using FileChooser
    @FXML
    public void saveFriends() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Friends");
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            for (Friend friend : friendsList) {
                friend.writeToFile(file.getPath());  // Save each friend to the selected file
            }
        }
    }

    // Load friends from a file using FileChooser
    @FXML
    public void loadFriends() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Friend List");
        File file = fileChooser.showOpenDialog(friendsListView.getScene().getWindow());

        if (file != null) {
            CreateFriend createFriend = new CreateFriend();
            List<Friend> loadedFriends = createFriend.createAllFriends(file.getPath());
            friendsList.clear();  // Clear current list
            friendsList.addAll(loadedFriends);  // Add loaded friends to the list view
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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