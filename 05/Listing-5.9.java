public void populateStudentCollection(ArrayList studentList) {
    studentList.clear();
    int count = getNumberOfStudents();
    studentList.ensureCapacity(count);
    for (int i = 0; i < count; i++) {
        studentList.set(i, getNextStudent());
    }

}