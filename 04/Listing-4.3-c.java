StudentRoster sr = new StudentRoster();
Student st = new Student();
.
.
// Putting the call to removeStudentFromList() in a code block that's
// synchronized on the instance of StudentList is functionally equivalent
// to adding the synchronized keyword to the method definition.
synchronized (sl) {
  sr.removeStudentFromList(st);
}
