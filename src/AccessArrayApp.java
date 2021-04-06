

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

/**
  *Main method that handles command-line arguments, prints all students or single student name..
  *@author: Ciaran Manca
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
   * Takes in ReadFile object, then builds the list of Student objects
   * @param file ReadFile object used to populate Student list.
   */
  public static Student[] buildList(ReadFile file) {
    String[][] studentListRaw = file.getList(); // calls ReadFile method getList to create a String list of all
                                              // student numbers and names
    Student[] studentObjectList = new Student[5000]; // creates a temporary list of Student object to be returned
    for (int i=0; i<5000;i++){
      String studentNumber = studentListRaw[i][0]; // uses .split to get student ID
      String name = studentListRaw[i][1];
      //String firstName = studentListRaw[i].split(" ")[1]; // uses .split to get first name
      //String lastName = studentListRaw[i].split(" ")[2]; // uses .split to get last name
      studentObjectList[i] = new Student(studentNumber, name); // creates new Student object with student ID, first name and last name
    }
    return studentObjectList; // returns the temporary list of Student object
  }

  public static void printAllStudents(Student[] studentList) {
    /*
      Prints all student ID, first name and last name from the given list of Student objects
    */
    for (int i=0; i<5000;i++){
      System.out.println(studentList[i]);
    }
  }

  public static void printStudent(Student[] studentList, Student otherStudent) {
    /*
      Prints matching Student first name and last name for the given student ID. Makes a new Student object
      with overloaded constructor that takes in only student ID. Uses the .getFirstName and .getLastName methods from
      Student class to print first and last names.
    */
    int count = 0; // instrumentation
    CreateCountFile("data/instrumentation/AccessArrayAppCount.txt");

    for (int i=0; i<5000; i++) {
      count ++;
      if (studentList[i].compareTo(otherStudent) == 0) {
        System.out.println(studentList[i].getName()); //getFirstName() + " " + studentList[i].getLastName());
        //System.out.println(count);
        WriteFile("data/instrumentation/AccessArrayAppCount.txt", Integer.toString(count));
        return;
      }
    }
    System.out.println("Access denied!");
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
