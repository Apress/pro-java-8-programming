public class Student {

    private int studentID;
    private String firstName;
    private String lastName;

    public Student(int id, String fname, String lname) {
        studentID = id;
        firstName = fname;
        lastName = lname;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

}