import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    private String[] sList = new String[5000];
    public ReadFile() {
      this.sList = sList;
    }
    public String[] getList() {
      try {
        File studentData = new File("oklist.txt");
        Scanner scanner = new Scanner(studentData);
        //String this.sList[] = new String[5000];
        int listCounter = 0;
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          this.sList[listCounter] = line;
          listCounter += 1;
        }


      } catch (FileNotFoundException e) {
        System.out.println("error");
        e.printStackTrace();
      }
      return this.sList;
    }






}
