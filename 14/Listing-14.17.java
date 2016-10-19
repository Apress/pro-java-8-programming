import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest6 {

  public static void main(String[] args) throws Exception {
    DOMTest6 dt = new DOMTest6();
  }

  public DOMTest6() throws Exception {
   DocumentBuilderFactory factory =
       DocumentBuilderFactory.newInstance();
   factory.setValidating(true);
   DocumentBuilder builder = factory.newDocumentBuilder();
   Document document = builder.newDocument();

   // ...
 }

}
