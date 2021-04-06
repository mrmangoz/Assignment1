/**
 * Student class to create student objects that hold student ID, first name and last name.
 * Implents Comparable to compare two student objects.
 */
public class Student implements Comparable<Student> {

  String studentNumber;
  String name;

  public Student (String s, String n) {
    studentNumber = s;
    name = n;
  }

  /*
   * Overloaded constructor to create Student object with only student ID.
   */
  public Student (String s) {
    studentNumber = s;
  }

  /**
   * Get method to return the student name.
   */
  public String getName() {
    return name;
  }

  /**
    * toString method to return student ID and name in the format "studentID Name"
    * ie. "MNCCIA001 Ciaran Manca"
    */
  public String toString() {
    // returns studen ID, first name and last name in a string
    return studentNumber + " " + name;
  }

  /**
    * compareTo method to compare another Student object with the current one.
    * @param other A different Student object.
    */
  public int compareTo ( Student other) {
    // compares this student object with another student object based on student ID
    // returns 0 if they are equal
    return studentNumber.compareTo(other.studentNumber);
  }

}
