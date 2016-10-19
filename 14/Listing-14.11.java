import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest2 {

  public static void main(String[] args) throws Exception {
    DOMTest2 dt = new DOMTest2s(args[0]);
  }

  public DOMTest2(String uri) throws Exception {
    DocumentBuilderFactory factory =
        DocumentBuilderFactory.newInstance();
    factory.setValidating(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(uri);
    System.out.println(doc.getDocumentElement());
  }
