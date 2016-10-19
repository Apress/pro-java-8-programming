public class StudentRoster {

  private java.util.Vector studentList;

  public synchronized void addStudentToList(Student st) {
    studentList.addElement(st);
    st.setEnrolled(true);
  }

  public void removeStudentFromList(Student st) {
    studentList.removeElement(st);
  }

  public static synchronized StudentRoster getNewInstance() {
    return new StudentRoster();
  }

}
