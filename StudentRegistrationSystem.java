package myProject;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main loop for program execution
        while (true) {
            System.out.println("Choose from the following options to start the registration process:");
            System.out.println("................................................................................");

            System.out.println("1. Register new student");
            System.out.println("2. View registered students");
            System.out.println("3. Help");
            System.out.println("4. Exit");
            System.out.println("/............................................/");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        new StudentRegistration(); // Register new student
                        break;
                    case 2:
                        viewRegisteredStudents(); // View registered students
                        break;
                    case 3:
                        displayHelp(); // Display help
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    // Method to view registered students
    private static void viewRegisteredStudents() {
        if (StudentRegistration.registeredStudents.isEmpty()) {
            System.out.println("No students registered yet.\n");
        } else {
            System.out.println("Registered Students:\n");
            for (Student student : StudentRegistration.registeredStudents) {
                displayStudentProfile(student);
            }
        }
    }
 // Method to display student profile
    private static void displayStudentProfile(Student student) {
        System.out.println("----------------------------------------------------");
        System.out.println("|                     STUDENT SLIP                   |");
        System.out.println("----------------------------------------------------");
        System.out.printf("| Full Name: %-38s|\n", student.fullName);
        System.out.printf("| ID Number: %-38s|\n", student.idNumber);
        System.out.printf("| sex: %-41s|\n", student.sex);
        System.out.printf("| Age: %-44s|\n", student.age);
        System.out.printf("| Phone Number: %-34s|\n", student.phoneNumber);
        System.out.printf("| Department: %-38s|\n", student.department);
        System.out.printf("| Academic year: %-34s|\n", student.academicYear);
        System.out.printf("| Academic Level: %-34s|\n", student.academicLevel);
        System.out.printf("| Semester: %-41s|\n", student.semester);
        System.out.printf("| Previous Semester CGPA: %-27s|\n", student.previousSemesterCGPA);
        System.out.println("----------------------------------------------------");
        System.out.println("|                    COURSES TO BE TAKEN                   |");
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-20s %-15s %-12s |\n", "Course Name", "Course Code", "Credit Hours");
        System.out.println("|----------------------|-----------------|------------|");
        for (Course course : student.courses) {
            System.out.printf("| %-20s %-15s %-12s |\n", course.courseName, course.courseCode, course.creditHours);
        }

        student.advisorSign("__________________________________");

        System.out.println("----------------------------------------------------");
        System.out.println("|                    STUDENT MESSAGE                 |");
        System.out.println("----------------------------------------------------");
        System.out.println("| Thank you for registering. Your information has    |");
        System.out.println("| been successfully recorded for the current semester.|");
        System.out.println("| Please keep this slip for your records.             |");
        System.out.println("----------------------------------------------------");
        System.out.println();
    }
    // Method to display help information
    private static void displayHelp() {
        System.out.println("Help Information:\n");
        System.out.println("1. To register a new student, choose option 1 and enter the required information.");
        System.out.println("2. To view registered students, choose option 2.");
        System.out.println("3. For additional help, choose option 3.");
        System.out.println("4. To exit the program, choose option 4.\n");
    }
}
