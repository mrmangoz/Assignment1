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
        File studentData = new File("data/oklist.txt");
        Scanner scanner = new Scanner(studentData);
        //System.out.println(studentData.getAbsolutePath());
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

  /*public void compareID(String studentID) {
    String [] idList = this.getList();

    for (int i=0; i<5000;i++){
      if (idList[i].split(" ")[0].equals(studentID)) {
        System.out.println(idList[i].split(" ")[1] + " " + idList[i].split(" ")[2]);
        return;
      }
    }

    System.out.println("Access Denied!");
  }*/








}
