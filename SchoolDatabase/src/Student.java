public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private static int studentCounter = 1; // Static field to create unique student numbers
    private int studentNumber;

    // Constructor to initialize fields
    public Student(){
        this.firstName = "";
        this.lastName = "";
        this.grade = 0;
        this.studentNumber = 0;
    }
    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNumber = studentCounter;
        studentCounter++;// Increment counter for unique student number
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }


    @Override
    public String toString() { // toString method to print student's information
        return "Name: " + firstName + " " + lastName + " | Grade: " + grade + " | Student Number: " + studentNumber;
    }
}
