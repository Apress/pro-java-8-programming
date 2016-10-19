class StudentComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {
        int relativeValue = s1.getStudentID() - s2.getStudentID();
        return relativeValue;
    }

}