import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

/**
  * Main method that handles command-line arguments, prints all students or single student name.
  * Counts the number of comparison operations done while searching and outputs to a text file.
  * Uses Student class and ReadFile class.
  * @author Ciaran Manca
  */
public class AccessArrayApp {
  public static void main (String args[]) {
    ReadFile file = new ReadFile(); // creates ReadFile object for accessing oklist.txt
    Student[] studentList = new Student[5000]; // creates list of Student object
    studentList = buildList(file); // builds the list of Student objects using buildList method
    try {
      // try catch for handling parameters given in commandline. If no parameters there is
      // an out of bounds error which then prints out all students.
      printStudent(studentList, new Student(args[0])); // uses the printStudent method to compare given student ID
    } catch (ArrayIndexOutOfBoundsException e) {
      printAllStudents(studentList); // uses printAllStudents method to print list of all students
    }
  }

  /**
   * Takes in ReadFile object, then builds the list of Student objects from that
   * and returns an array of Student objects.
   * @param file ReadFile object used to populate Student list.
   */
  public static Student[] buildList(ReadFile file) {
    String[][] studentListRaw = file.getList(); // calls ReadFile method getList to create a String list of all
                                              // student numbers and names
    Student[] studentObjectList = new Student[5000]; // creates a temporary list of Student object to be returned
    for (int i=0; i<5000;i++){
      if (studentListRaw[i][0] == null) {
        break;
      }
      String studentNumber = studentListRaw[i][0];
      String name = studentListRaw[i][1];
      studentObjectList[i] = new Student(studentNumber, name); // creates new Student object with student ID, first name and last name
    }
    return studentObjectList; // returns the temporary list of Student object
  }

  /**
   * Prints all student ID, first name and last name from the given list of Student objects.
   * @param studentList Array of Student object.
   */
  public static void printAllStudents(Student[] studentList) {
    for (int i=0; i<5000;i++){
      System.out.println(studentList[i]);
    }
  }

  /**
   * Prints matching Student first name and last name for the given student ID in the form of another Student object.
   * Uses the getName method from Student class to print first and last names.
   * Writes operation counter to output file.
   * @param studentList Array of Student objects.
   * @param otherStudent A single Student object.
   */
  public static void printStudent(Student[] studentList, Student otherStudent) {
    int count = 0; // instrumentation
    CreateCountFile("data/instrumentation/AccessArrayAppCount.txt");
    for (int i=0; i<5000; i++) {
      count ++;
      if (studentList[i].compareTo(otherStudent) == 0) {
        System.out.println(studentList[i].getName());
        WriteFile("data/instrumentation/AccessArrayAppCount.txt", Integer.toString(count));
        return;
      }
    }
    System.out.println("Access denied!");
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
