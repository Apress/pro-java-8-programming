IdentityHashMap<Integer,Student> map = new IdentityHashMap<>();
Student s1 = new Student(12345, "John", "Smith");
map.put(s1.getStudentID(), s1);
map.put(s1.getStudentID(), s1);
for (Student s : map.values()) {
    System.out.println(s.getStudentID() + " " + s.getFullName());
}