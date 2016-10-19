public class ScanTest {

    public static void main(String[] args) throws Exception {
        Class<SimpleTest> myClass = SimpleTest.class;
        if (myClass.isAnnotationPresent(RemoteObject.class)) {
            System.out.println("It is a RemoteObject");
        }
        else {
            System.out.println("It doesn't appear to be a RemoteObject!");
        }
    }

}
