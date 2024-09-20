public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;

    // Constructor to initialize fields
    public Teacher(){
        this.firstName = "";
        this.lastName = "";
        this.subject = "";
    }
    public Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // toString method to print teacher's information
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "; Subject: " + subject;
    }
}
