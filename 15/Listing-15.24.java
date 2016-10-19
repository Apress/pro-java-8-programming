import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface GeneratorHome extends EJBHome {
    public MessageGenerator create() throws RemoteException, CreateException;
}
