class Student implements Comparable<Student> {
  /*
    Student class to create student objects that hold student ID, first name and last name.
    Implents Comparable to compare two student objects.
  */

  String studentNumber;
  String name;
  //String firstName;
  //String lastName;

  public Student (String s, String n) {
    studentNumber = s;
    name = n;
    //firstName = f;
    //lastName = l;
  }

  public Student (String s) {
    studentNumber = s;
  }

  /*public String getFirstName () {
    // returns fist name
    return firstName;
  }*/

  /*public String getLastName () {
    // returns last name
    return lastName;
  }*/

  public String getName() {
    return name;
  }

  public String toString() {
    // returns studen ID, first name and last name in a string
    return studentNumber + " " + name;
  }

  public int compareTo ( Student other) {
    // compares this student object with another student object based on student ID
    // returns 0 if they are equal
    return studentNumber.compareTo(other.studentNumber);
  }

}
