import java.rmi.*;

public interface Test extends Remote {

    public String getText() throws RemoteException;

}
