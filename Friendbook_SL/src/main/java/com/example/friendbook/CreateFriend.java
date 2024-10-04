package com.example.friendbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateFriend {

    // Method to load all friends from a text file
    public List<Friend> createAllFriends(String fileName) throws IOException {
        // Check if the file is a .txt file
        if (!fileName.endsWith(".txt")) {
            throw new IOException("Only .txt files are supported.");
        }

        List<Friend> friends = new ArrayList<>();
        String friendString = ""; // Accumulate the friend data

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                // Accumulate data until we hit the semicolon
                friendString += line + "\n"; // Accumulate each line (add newline to preserve structure)
            } else {
                // Parse the accumulated friend data when we encounter a semicolon
                friends.add(parseFriend(friendString.trim())); // Add parsed friend to the list
                friendString = ""; // Reset for the next friend
            }
        }
        br.close(); // Close the BufferedReader manually

        return friends;
    }

    // This method will parse the accumulated friend string and create a Friend object
    private Friend parseFriend(String friendString) {
        String[] friendInfo = friendString.split("\n"); // Split by newline to get each part of the friend's data
        if (friendInfo.length == 3) {
            String name = friendInfo[0].replace(",", "").trim();  // Get the name and remove the trailing comma
            String email = friendInfo[1].replace(",", "").trim(); // Get the email and remove the trailing comma
            String phone = friendInfo[2].replace(",", "").trim(); // Get the phone and remove the trailing comma
            return new Friend(name, email, phone); // Return a new Friend object
        }
        return null; // In case the data is malformed
    }
}
