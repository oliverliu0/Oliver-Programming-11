public class Main {
    public static void main(String[] args) {
        School LordByngSecondary = new School("Lord Byng Secondary", "3939 W 16th Ave", "1500");

        // Print school details
        System.out.println("School details: \nSchool Name: " + LordByngSecondary.getName() +
                "\nAddress: " + LordByngSecondary.getAddress() +
                "\nNumber of Students: " + LordByngSecondary.getNumberofstudents());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Add 10 students to the student list
        LordByngSecondary.addStudent(new Student("LeBron", "James", 10));
        LordByngSecondary.addStudent(new Student("Michael", "Jordan", 11));
        LordByngSecondary.addStudent(new Student("Kylian", "Mbappe", 9));
        LordByngSecondary.addStudent(new Student("Usain", "Bolt", 12));
        LordByngSecondary.addStudent(new Student("Tom", "Brady", 10));
        LordByngSecondary.addStudent(new Student("Michael", "Phelps", 11));
        LordByngSecondary.addStudent(new Student("Lionel", "Messi", 9));
        LordByngSecondary.addStudent(new Student("David", "Beckham", 12));
        LordByngSecondary.addStudent(new Student("Neymar", "Jr", 10));
        LordByngSecondary.addStudent(new Student("Cristiano", "Ronaldo", 11));

        // Add 3 teachers to the teacher list
        for (int i = 0; i < 3; i++) {
            String n = "" + (i + 1); // Concatenates an empty string with (i + 1) to form a string
            Teacher teacher = new Teacher("Teacher", n, "Subject " + n); // Create a new Teacher object
            LordByngSecondary.addTeacher(teacher); // Add the teacher to the school
        }


        // Display both lists
        System.out.println("All Teachers:");
        LordByngSecondary.showAllTeachers(); //displays all teachers at school

        System.out.println("\nAll Students:");
        LordByngSecondary.showAllStudents(); //displays all students at school

        // Removes the first two students
        for (int i = 0; i < 2; i++) {
            LordByngSecondary.deleteStudent(LordByngSecondary.getStudents().get(0));
        }


        // Remove 1 teacher
        LordByngSecondary.deleteTeacher(LordByngSecondary.getTeachers().get(0)); // Removes the first teacher

        // Display remaining list
        System.out.println("\nAfter removal of two students and one teacher:");
        System.out.println("All Teachers:");
        LordByngSecondary.showAllTeachers(); //displays remaining teachers at school

        System.out.println("\nAll Students:");
        LordByngSecondary.showAllStudents(); //displays remaining students at school
    }

}
