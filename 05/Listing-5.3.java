Student student;
Iterator iterator = collection.iterator();
while (iterator.hasNext()) {
    student = (Student)(iterator.next());
    System.out.println(student.getFullName());
}