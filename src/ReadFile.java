import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ReadFile class for handling reading text file. Has method to return a String list
 * of student ID, first name and surname.
 * @author Ciaran Manca
 */
public class ReadFile {
    private String[][] sList = new String[5000][2]; // creates String list
    public ReadFile() {
      this.sList = sList;
    }

    /**
      * Get method to return String array of oklist.txt. List format is [["studentid", "name"],["studentid", "name"],...]
      */
    public String[][] getList() {
      try {
        // try catch for file handling
        File studentData = new File("data/oklist.txt"); // creates new File object from oklist.txt
        Scanner scanner = new Scanner(studentData); // creates new Scanner
        int listCounter = 0; // creates counter object that tracks the line number of the file being read
                             // and uses it to add the student data to the correct entry in the student list
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          String studentID = line.split(" ")[0];
          String firstName = line.split(" ")[1];
          String lastName = line.split(" ")[2];
          String name = firstName + " " + lastName;
          this.sList[listCounter][0] = studentID; // adds text file line to student list
          this.sList[listCounter][1] =  name;
          listCounter += 1;
        }
      } catch (FileNotFoundException e) {
        // basic error handling if no file is found
        System.out.println("No file found");
        e.printStackTrace();
      }
      return this.sList; // returns the String list of student ID, first name and last name
    }
}
