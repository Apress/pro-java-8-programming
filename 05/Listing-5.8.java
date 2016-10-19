public boolean equals(Object o) {
    boolean isEqual = false;
    if ((o != null) && (o instanceof Student)) {
        Student target = (Student)o;
        isEqual = (target.getStudentID() == this.getStudentID());
    }
    return isEqual;
}