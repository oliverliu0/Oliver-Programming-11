package com.example.friendbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    private String name;
    private String email;
    private String phone;

    // Constructor
    public Friend(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Override toString for ListView to display friend name
    @Override
    public String toString() {
        return name;
    }

    // Write the friend object to a file
    public void writeToFile(String fileName) throws IOException {
        // Check if the file is a .txt file
        if (!fileName.endsWith(".txt")) {
            throw new IOException("Only .txt files are supported.");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(name + ",\r");
        writer.write(email + ",\r");
        writer.write(phone + "\r");
        writer.write(";\r");  // End of a friend's record
        writer.close();  // Close the writer manually
    }
}
