package myProject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
//Base class for common attributes
class Student implements StudentInformation {
 String fullName;
 String idNumber;
 String sex;
 String phoneNumber;
 int age;
 String universityName;
 String department;
 int academicLevel;
 double previousSemesterCGPA;
 String semester;
 int academicYear;
 ArrayList<Course> courses;

 // Constructor
 
 public Student() {
     System.out.println("WELCOME TO THE REGISTRATION");
     System.out.println(".............................................");
     System.out.println("\nEnter your Information:");
     System.out.println("......................................");
     studInfoInput();
     courses = new ArrayList<>();
     if (previousSemesterCGPA >= 1.5 && previousSemesterCGPA <= 4.0) {
         advisor();
     }
 }
    // method to display the courses going to be taken for the current semister
 
 public void displayCoursesOnSlip() {
     System.out.println("----------------------------------------------------");
     System.out.println("|                    COURSES TAKEN                   |");
     System.out.println("----------------------------------------------------");
     System.out.printf("| %-20s %-15s %-12s |\n", "Course Name", "Course Code", "Credit Hours");
     System.out.println("|----------------------|-----------------|------------|");
     for (Course course : courses) {
         System.out.printf("| %-20s %-15s %-12s |\n", course.courseName, course.courseCode, course.creditHours);
     }
     System.out.println("----------------------------------------------------");
 }
// method to print the advisor name and signature on the student slip
 
 public void advisorSign(String advisorName) {
     System.out.println("----------------------------------------------------");
     System.out.println("|                   ADVISOR SIGNATURE                |");
     System.out.println("----------------------------------------------------");
     System.out.println("| Advisor Name: " + advisorName);
     System.out.println("| Signature: ____________ Date: ________________    |");
     System.out.println("----------------------------------------------------");
 }
/* method to call the advisor when the student is allowed to register for the current semister 
 * to fill the detail information on the student slip about the courses to be taken */
 
 private void advisor() {
     Scanner scanner = new Scanner(System.in);

     // Input validation for the number of courses
     int numCourses;
     do {
         try {
             System.out.println("since the student is allowed to register for the current semister ");
             System.out.println("please mr.Advisor enter the course information going to taken by the student");
             System.out.println("in order to display the course taken on the student slip");
             System.out.print("Enter the number of courses: ");
             numCourses = scanner.nextInt();
             scanner.nextLine(); // Consume the newline character

             if (numCourses <= 0) {
                 System.out.println("Invalid input. Please enter a positive number of courses.");
             }
         } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a valid integer for the number of courses.");
             scanner.nextLine(); // Consume the invalid input
             numCourses = -1; // Reset numCourses to force re-entry in the next iteration
         }
     } while (numCourses <= 0);

     // Input course information
     
     for (int i = 0; i < numCourses; i++) {
         System.out.println("Enter information for Course " + (i + 1));
         System.out.print("Course Name: ");
         String courseName = scanner.nextLine();
         System.out.print("Course Code: ");
         String courseCode = scanner.nextLine();
         int creditHours;
         do {
             try {
                 System.out.print("Credit Hours: ");
                 creditHours = scanner.nextInt();
                 scanner.nextLine(); // Consume the newline character

                 if (creditHours <= 0) {
                     System.out.println("Invalid input. Please enter a positive number for credit hours.");
                 }
             } catch (InputMismatchException e) {
                 System.out.println("Invalid input. Please enter a valid integer for credit hours.");
                 scanner.nextLine(); // Consume the invalid input
                 creditHours = -1; // Reset creditHours to force re-entry in the next iteration
             }
         } while (creditHours <= 0);

         courses.add(new Course(courseName, courseCode, creditHours));
     }
 }

 // Implementation of interface method
 public void studInfoInput() {
     Scanner scanner = new Scanner(System.in);

     // Input validation for Full Name (String)
     do {
         System.out.print("Enter your full name: ");
         fullName = scanner.nextLine();

         String[] nameParts = fullName.split(" ");

         if (nameParts.length < 2 || !fullName.matches("^[a-zA-Z ]+$")) {
             System.out.println("Invalid input. Please enter a valid name with at least two parts.");
         }
     } while (fullName.split(" ").length < 2 || !fullName.matches("^[a-zA-Z ]+$"));
     System.out.println("...............................................................");
     
     // Input validation for ID Number (Integer)
     do {
         try {
             System.out.print("Enter your id number: ");
             idNumber = scanner.nextLine();

             if (!idNumber.matches("^[0-9/tsTS]+$")) {
                 System.out.println("please enter the valid input only inludes 0-9, /, T, S, t, s");
             }
         } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a valid id number.");
             scanner.nextLine(); // Consume the invalid input
         }
     } while (!idNumber.matches("^[0-9/tsTS]+$"));
     System.out.println("...............................................................");
     
     // Input validation for Gender (String)
     do {
         System.out.print("enter your sex: ");
         sex = scanner.nextLine().toLowerCase();
         if (!sex.matches("^(f|female|m|male)$")) {
             System.out.println("Invalid input. Please enter a valid gender (f, m, female, or male).");
         }
     } while (!sex.matches("^(f|female|m|male)$"));
     System.out.println("...............................................................");
     
     // to check the phone number is 10 digits
     do {
         System.out.print("Enter your Phone Number: ");
         phoneNumber = scanner.nextLine();
         if (!phoneNumber.matches("^\\d{10}$")) {
             System.out.println("Invalid input. Please enter a 10-digit phone number.");
         }
     } while (!phoneNumber.matches("^\\d{10}$"));
     System.out.println("...............................................................");
     
     // Input validation for Age (Integer between 18 and 40)
     do {
         try {
             System.out.print("Age: ");
             age = scanner.nextInt();
             scanner.nextLine(); // Consume the newline character

             if (age < 18 || age > 40) {
                 System.out.println("Invalid age. Age must be between 18 and 40.");
             }
         } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a valid integer for age.");
             scanner.nextLine(); // Consume the invalid input
             age = -1; // Reset age to force re-entry in the next iteration
         }
     } while (age < 18 || age > 40);
     System.out.println("...............................................................");
     
     // Input validation for Department (String, no numbers)
     do {
         System.out.print("Enter your department: ");
         department = scanner.nextLine();
         if (!department.matches("^[a-z A-Z ]+$")) {
             System.out.println("Invalid input. Department name should only contain letters.");
         }
     } while (!department.matches("^[a-z A-Z ]+$"));
     System.out.println("...............................................................");
     
     // Input validation for Department (String, no numbers)
     do {
         System.out.print("Enter your universityName college: ");
         universityName = scanner.nextLine();
         if (!universityName.matches("^[a-z A-Z ]+$")) {
             System.out.println("Invalid input. universityName Name should only contain letters.");
         }
     } while (!universityName.matches("^[a-z A-Z ]+$"));
     System.out.println("...............................................................");
     
     // Input validation for Semester (String, allowed values: "i", "ii", "1", "2")
     
     do {
         System.out.print("Enter the current Semester: ");
         semester = scanner.nextLine().toLowerCase();
         if (!semester.matches("^[iI1-2]+$")) {
             System.out.println("Invalid semester. Enter either 'i', 'ii', '1', or '2'.");
         }
     } while (!semester.matches("^[iI1-2]+$"));
     System.out.println("...............................................................");
     
     // Input validation for Academic level (Integer between 1 and 7)
     do {
         try {
             System.out.print("Enter your Academic level: ");
             academicLevel = scanner.nextInt();
             scanner.nextLine(); // Consume the newline character

             if (academicLevel < 1 || academicLevel > 7) {
                 System.out.println("Invalid academic year. Enter a year between 1 and 7.");
             }
         } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a valid integer for academic Level.");
             scanner.nextLine(); // Consume the invalid input
             academicLevel = -1; // Reset academicLevel to force re-entry in the next iteration
         }
     } while (academicLevel < 1 || academicLevel > 7);
     System.out.println("...............................................................");
     
     // input validation for academic year for it is only four digit number 
     
     do {
         System.out.print("Enter your academic year (four-digit number): ");
         
         while (!scanner.hasNextInt()) {
             System.out.println("Invalid input. Please enter a four-digit number.");
             System.out.print("Enter your academic year (four-digit number): ");
             scanner.next(); // consume the invalid input
         }

         academicYear = scanner.nextInt();

         if (academicYear < 1000 || academicYear > 9999) {
             System.out.println("Invalid input. Please enter a four-digit number.");
         }

     } while (academicYear < 1000 || academicYear > 9999);

       
      System.out.println("...............................................................");
      
     // Input validation for Previous Semester CGPA if it is between 1.5 and 4.00 including both
     do {
         try {

             System.out.print("Enter your Previous Semester CGPA: ");
             previousSemesterCGPA = scanner.nextDouble();
             scanner.nextLine(); // Consume the newline character

             if (previousSemesterCGPA < 1.5 && previousSemesterCGPA >= 1.00) {
                 System.out.println("you are not qualified to register for this semister");
                 System.out.println("please contact your department for more information");
                 System.out.println("but if you are a freshman first semister student");
                 System.out.println("you can fill the form for the next readmission program");
                 System.out.println("insert yes to continue or no to exit, yes or no :");
                 String mychoice = scanner.nextLine();
                 if (mychoice.equalsIgnoreCase("yes")) {
                     studInfoInput();
                 } else if (mychoice.equalsIgnoreCase("no")) {
                     System.exit(0);
                 }
      
                 
             } else if (previousSemesterCGPA < 1 && previousSemesterCGPA > 0.0) {
                 System.out.println("you are dismissed collect your things to leave the university!");
                 System.out.println("insert yes to continue or no to exit, yes or no :");
                 String mychoice = scanner.nextLine();
                 if (mychoice.equalsIgnoreCase("yes")) {
                     studInfoInput();
                 } else if (mychoice.equalsIgnoreCase("no")) {
                     System.exit(0);
                 }

             } else if (previousSemesterCGPA > 4.00) {
                 System.out.println("there is no such gpa as a grade policy of the universities");
             } else if (previousSemesterCGPA == 0.0) {
                 System.out.println("registration for freshman students with no cgpa is not available now");
                 System.exit(0);
             }

         } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a valid decimal number for GPA.");
             scanner.nextLine(); // Consume the invalid input
             previousSemesterCGPA = -1.0; // Reset previousSemesterGPA to force re-entry in the next iteration
         }
     } while (previousSemesterCGPA < 1.5 || previousSemesterCGPA > 4.0);
     System.out.println("...............................................................");

 }
}