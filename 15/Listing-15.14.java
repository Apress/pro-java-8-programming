import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class SimpleTest extends UnicastRemoteObject implements Test {

    public SimpleTest() throws RemoteException {
    }

    @RemoteObject
    public String getText() {
        return "Hello world!";
    }

}
