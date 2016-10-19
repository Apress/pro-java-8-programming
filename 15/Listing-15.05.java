Class myClass = Server.class;
java.lang.reflect.Method[] methods = myClass.getMethods();
for (int i = 0; i < methods.length; i++) {
       if (methods[i].isAnnotationPresent(Deprecated.class)) {
           System.err.println("Method '" + methods[i].getName() + "' is deprecated");
      }
}
