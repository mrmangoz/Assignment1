import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class AccessBSTApp {
  public static void main (String args[]) {
    ReadFile file = new ReadFile();
    BinarySearchTree<Student> bSTStudent = new BinarySearchTree<Student> ();
    bSTStudent = buildBST(file);

    try {
      printStudent(bSTStudent, new Student(args[0]));
    } catch (ArrayIndexOutOfBoundsException e) {
      printAllStudents(bSTStudent);
    }

    // bSTStudent.inOrder(); // prints all students in order
  }

  public static BinarySearchTree<Student> buildBST(ReadFile file) {
    /*
      Takes in ReadFile object, then builds the list of Student objects
    */
    String[][] studentListRaw = file.getList(); // calls ReadFile method getList to create a String list of all
                                              // student numbers and names
    BinarySearchTree<Student> bSTTemp = new BinarySearchTree<Student> (); // creates a temporary list of Student object to be returned
    for (int i=0; i<5000;i++){
      if (studentListRaw[i][0] == null) {
        break;
      }
      String studentNumber = studentListRaw[i][0]; // uses .split to get student ID
      String name = studentListRaw[i][1];
      bSTTemp.insert(new Student(studentNumber, name)); // creates new Student object with student ID, first name and last name
    }
    //bSTTemp.inOrder();
    return bSTTemp; // returns the temporary list of Student object
  }

  public static void printStudent(BinarySearchTree<Student> bSTStudent, Student otherStudent) {
    CreateCountFile("data/instrumentation/AccessBSTAppCount.txt");
    if (bSTStudent.find(otherStudent) != null) {
      WriteFile("data/instrumentation/AccessBSTAppCount.txt", Integer.toString(bSTStudent.getCount()));
      System.out.println(bSTStudent.find(otherStudent).getData().getName());
    } else {
      System.out.println("Access denied!");
    }



  }
  public static void printAllStudents(BinarySearchTree<Student> bSTStudent) {
    /*
      Prints all student ID, first name and last name from the given list of Student objects
    */
    bSTStudent.inOrder(); // prints all students in order
  }

  public static void CreateCountFile(String filePath) {
      File tempFile = new File(filePath);
  }

  public static void WriteFile(String filePath, String data) {
    try {
      FileWriter fileWriter = new FileWriter(filePath);
      fileWriter.write(data);
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("Error occured.");
    }


  }
}
