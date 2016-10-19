import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest3 {
  public static void main(String[] args) throws Exception {
    DOMTest3 dt = new DOMTest3(args[0]);
  }

  public DOMTest3(String uri) throws Exception {
    DocumentBuilderFactory factory =
        DocumentBuilderFactory.newInstance();
    factory.setValidating(true);
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document doc = builder.parse(uri);
    Element rootElement = doc.getDocumentElement();
    NodeList children = rootElement.getChildNodes();
    Node current = null;
    int count = children.getLength();
    for (int i = 0; i < count; i++) {
       current = children.item(i);
       if (current.getNodeType() == Node.ELEMENT_NODE) {
         Element element = (Element)current;
         if (element.getTagName().equalsIgnoreCase("tableOfContents")) {
           element.setAttribute("showPageNumbers", "no");
         }
      }
    }
    System.out.println(doc.getDocumentElement());
  }
}
