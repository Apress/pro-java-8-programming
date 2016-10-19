HashMap<Integer,Student> map = new HashMap<>();
Student s1 = new Student(12345, "John", "Smith");
Student s2 = new Student(24680, "Jane", "Smith");
Student s3 = new Student(13579, "Adam", "Smith");
Student s4 = new Student(67890, "Tom", "Jones");
map.put(s1.getStudentID(), s1);
map.put(s2.getStudentID(), s2);
map.put(s3.getStudentID(), s3);
map.put(s4.getStudentID(), s4);