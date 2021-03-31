import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import ReadFile;

class AccessArrayApp {
  public static void main (String args[]) {
    try {
      printStudent(args[0]);
      //System.out.println(args[0]);
    } catch (ArrayIndexOutOfBoundsException e) {
      printAllStudents();
      //System.out.println("test");
    }


      //printStudent(args[0]);

      //printAllStudents();


  }

  private static String[] buildList() {
    ReadFile file = new ReadFile();
    String[] studentList = file.getList();
    return studentList;
  }
  public static void printAllStudents() {
    String[] studentList = buildList();
    for (int i=0; i<5000;i++){
      System.out.println(studentList[i]);
    }
  }

  public static void printStudent(String studentID) {
    ReadFile file = new ReadFile();
    file.compareID(studentID);
    //System.out.println("printStudent");
    //System.out.println(studentID);
    //String[] studentList = buildList();
    //System.out.println(studentList[0].split(" ")[0]);
    //boolean found = false;
    //for (int i=0; i<5000;i++){
      //System.out.println(studentList[i].split(" ")[0]);
    //  if (studentList[i].split(" ")[0].equals(studentID)){
    //    System.out.println(studentList[i].split(" ")[1] + " " + studentList[i].split(" ")[2]);
    //    found = true;
    //    break;
    //  }
    //
    //}
    //if (!found) {
    //  System.out.println("Access Denied!");
    //}
    //if (ReadFile.compareID(studentID)) {
    //  System.out.println()
    //}
  }
}
