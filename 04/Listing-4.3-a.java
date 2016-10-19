public class StudentRoster {

  private java.util.Vector studentList;

  public void addStudentToList(Student st) {
    synchronized (studentList) {
      studentList.addElement(st);
    }
    st.setEnrolled(true);
  }

  public void removeStudentFromList(Student st) {
    studentList.removeElement(st);
  }

}
