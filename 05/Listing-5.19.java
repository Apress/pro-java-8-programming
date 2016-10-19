IdentityHashMap<Integer,Student> map = new IdentityHashMap<>();
map.put(new Integer (123), null);
map.put(new Integer (123), null);
for (Integer i : map.keySet()) {
    System.out.println(i);
}