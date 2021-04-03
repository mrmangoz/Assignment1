class AccessBSTApp {
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
    String[] studentListRaw = file.getList(); // calls ReadFile method getList to create a String list of all
                                              // student numbers and names
    BinarySearchTree<Student> bSTTemp = new BinarySearchTree<Student> (); // creates a temporary list of Student object to be returned
    for (int i=0; i<5000;i++){
      String studentNumber = studentListRaw[i].split(" ")[0]; // uses .split to get student ID
      String firstName = studentListRaw[i].split(" ")[1]; // uses .split to get first name
      String lastName = studentListRaw[i].split(" ")[2]; // uses .split to get last name
      bSTTemp.insert(new Student(studentNumber, firstName, lastName)); // creates new Student object with student ID, first name and last name
    }
    //bSTTemp.inOrder();
    return bSTTemp; // returns the temporary list of Student object
  }

  public static void printStudent(BinarySearchTree<Student> bSTStudent, Student otherStudent) {
    int count = 0;
    count ++;
    if (bSTStudent.find(otherStudent) != null) {
      bSTStudent.visit(bSTStudent.find(otherStudent));
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
}
