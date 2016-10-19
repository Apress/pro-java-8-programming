StudentRoster sr;
.
.
// The following code is equivalent to adding synchronized to the
// removeStudentFromList() method's definition, because it causes
// the running thread to attempt to obtain the lock of the Class
// object associated with StudentList.
synchronized (StudentRoster.class) {
  sr = StudentRoster.getNewInstance();
}
