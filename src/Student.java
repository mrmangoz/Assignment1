class Student implements Comparable<Student> {
  String studentNumber;
  String firstName;
  String lastName;

  public Student (String s, String f, String l) {
    studentNumber = s;
    firstName = f;
    lastName = l;
  }

  public Student (String s) {
    studentNumber = s;
  }

  public String getFirstName () {
    return firstName;
  }

  public String getLastName () {
    return lastName;
  }

  public String toString() {
    return studentNumber + " " + firstName + " " + lastName;
  }

  public int compareTo ( Student other) {
    return studentNumber.compareTo(other.studentNumber);
  }

}
