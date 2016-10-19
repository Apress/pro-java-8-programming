Collection<Student> collection = new HashSet<>();
Student s1 = new Student(12345, "John", "Smith");
Student s2 = new Student(67890, "Jane", "Smith");
Student s3 = new Student(13579, "Adam", "Smith");
Student s4 = new Student(67890, "Tom", "Jones");
collection.add(s1);
collection.add(s2);
collection.add(s3);
collection.add(s4);
for (Student student : collection) {
    System.out.println(student.getFullName());
}