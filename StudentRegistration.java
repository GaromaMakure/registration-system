package myProject;
import java.util.ArrayList;

//Derived class to handle student registration
class StudentRegistration extends Student {
 // ArrayList to store registered students
 static ArrayList<Student> registeredStudents = new ArrayList<>();

 // Constructor
 public StudentRegistration() {
     super(); // Calls the constructor of the base class (Student)
     registeredStudents.add(this); // Add the current student to the list
     System.out.println("Student successfully registered!\n");
 }
}
