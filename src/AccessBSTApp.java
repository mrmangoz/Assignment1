import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

/**
  * Main method that handles command-line arguments, prints all students or single student name.
  * Counts the number of comparison operations done while searching and outputs to a text file.
  * Uses Student class, ReadFile class and Binary Search Tree classes written by Hussein Suleman.
  * @author Ciaran Manca
  */
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
  }

  /**
   * Takes in ReadFile object, build a String array from ReadFile and uses it to populate BST.
   * Returns Binary Search Tree.
   * @param file ReadFile object for building String array.
   */
  public static BinarySearchTree<Student> buildBST(ReadFile file) {
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
    return bSTTemp; // returns the temporary list of Student object
  }

  /**
   * Prints matching Student first name and last name for the given student ID in the form of another Student object.
   * Uses the getName method from Student class to print first and last names.
   * Writes the operation counter to output file.
   * @param bSTStudent Binary Search Tree of Student objects.
   * @param otherStudent A single Student object.
   */
  public static void printStudent(BinarySearchTree<Student> bSTStudent, Student otherStudent) {
    CreateCountFile("data/instrumentation/AccessBSTAppCount.txt");
    if (bSTStudent.find(otherStudent) != null) {
      WriteFile("data/instrumentation/AccessBSTAppCount.txt", Integer.toString(bSTStudent.getCount()));
      System.out.println(bSTStudent.find(otherStudent).getData().getName());
    } else {
      System.out.println("Access denied!");
    }
  }

  /**
   * Prints all student ID, first name and last name from the BinarySearchTree using the inOrder method.
   * @param bSTStudent Binary Search Tree of Student objects.
   */
  public static void printAllStudents(BinarySearchTree<Student> bSTStudent) {
    bSTStudent.inOrder(); // prints all students in order
  }

  /**
   * Method for creating new file to write operation counter to.
   * @param filePath String containing the path for the file to be created.
   */
  public static void CreateCountFile(String filePath) {
      File tempFile = new File(filePath);
  }

  /**
   * Method for writing the operation counter to a file.
   * @param filePath String containing the path to the desired file to write to.
   * @param data String to be written to file.
   */
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
