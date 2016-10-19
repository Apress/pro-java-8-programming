import javax.ejb.*;

public class SimpleMessageGenerator implements SessionBean {

    private SessionContext context;

    public SimpleMessageGenerator() {
    }

    public void ejbCreate() throws CreateException {
    }

    public void setSessionContext(SessionContext theContext) {
        context = theContext;
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public String getMessage() {
        return "Hello world!";
    }

}
