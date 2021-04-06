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

  public Student (String s) {
    studentNumber = s;
  }

  /**
   * @return Student first and last name in format "firstname last name"
   */
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
