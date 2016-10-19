import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface MessageGenerator extends EJBObject {

    public String getMessage() throws RemoteException;

}
