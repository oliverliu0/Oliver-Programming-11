import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    private String name; // Example of a field
    private String address; // Example of a field
    private String numberofstudents; // Example of a field

    // Constructor to initialize the school with name, address, and principal
    public School(){
        this.name = "";
        this.address = "";
        this.numberofstudents = "";
    }
    public School(String name, String address, String numberofstudents) {
        this.name = name;
        this.address = address;
        this.numberofstudents = numberofstudents;
    }

    // Add a teacher to the list
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Add a student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Delete a teacher from the list
    public void deleteTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    // Delete a student from the list
    public void deleteStudent(Student student) {
        students.remove(student);
    }

    // Getter for students list
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Getter for teachers list
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    // Show all teachers
    public void showAllTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    // Show all students
    public void showAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberofstudents() {
        return numberofstudents;
    }

    public void setNumberofstudents(String numberofstudents) {
        this.numberofstudents = numberofstudents;
    }
}
