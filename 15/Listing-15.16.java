import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

@RemoteObject
public class SimpleTest extends UnicastRemoteObject implements Test {

    public SimpleTest() throws RemoteException {
    }

    public String getText() {
        return "Hello world!";
    }

}
