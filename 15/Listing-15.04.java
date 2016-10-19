Class myClass = Server.class;
java.lang.reflect.Method[] methods = myClass.getMethods();
for (int i = 0; i < methods.length; i++) {
    // Check for annotations here
}
