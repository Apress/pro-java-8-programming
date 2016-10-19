Integer integer;
Random random = new Random();
Collection collection = new ArrayList ();
for (int i = 0; i < 10; i++) {
    integer = new Integer (random.nextInt());
    collection.add(integer);
}