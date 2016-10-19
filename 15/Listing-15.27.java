import javax.ejb.*;

@Remote @Stateless
public class SimpleMessageGenerator {

public SimpleMessageGenerator() {

public String getMessage() {
        return "Hello world!";
    }

}
