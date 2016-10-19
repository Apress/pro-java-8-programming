Student student;
Set<Integer> keys = map.keySet();
for (Integer i : keys) {
    student = map.get(i);
    System.out.println("Key: " + i + " Value:" + student.getFullName());
}