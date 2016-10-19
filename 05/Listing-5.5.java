Integer integer;
int total = 0;
Iterator iterator = collection.iterator();
while (iterator.hasNext()) {
    integer = (Integer)(iterator.next());
    total += integer.intValue();
}