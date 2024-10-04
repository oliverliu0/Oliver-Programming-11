package com.example.friendbook;

public class Friend {
    private String name;
    private String email;
    private String phone;

    // Constructor
    // Requires: String for name, string for email, and string for phone
    //Modifies: this
    //Effects: creating an instance of friend class and assign user name, email and phone to this instance.
    public Friend(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    // Requires: it must be related to friend class instance
    // Modifies: N/A
    // Effects: it will return the name of the friend instance
    public String getName() {
        return name;
    }

    // Requires: it must be related to friend class instance, a string type of name as input
    // Modifies: this
    // Effects: it will change the name of the friend class instance
    public void setName(String name) {
        this.name = name;
    }

    // Requires: it must be related to friend class instance
    // Modifies: N/A
    // Effects: it will return the email of the friend instance
    public String getEmail() {
        return email;
    }

    // Requires: it must be related to friend class instance, a string type of email as input
    // Modifies: this
    // Effects: it will change the email of the friend class instance
    public void setEmail(String email) {
        this.email = email;
    }

    // Requires: it must be related to friend class instance
    // Modifies: N/A
    // Effects: it will return the phone number of the friend instance
    public String getPhone() {
        return phone;
    }

    // Requires: it must be related to friend class instance, a string type of phone number as input
    // Modifies: this
    // Effects: it will change the phone number of the friend class instance
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Override toString for ListView to display friend name
    // Requires: it must be related to friend class instance.
    // Modifies: N/A
    // Effects: Override toString for ListView to display friend name
    @Override
    public String toString() {
        return name;
    }
}
