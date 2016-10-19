import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest4 {

  public static void main(String[] args) throws Exception {
    DOMTest4 dt = new DOMTest4(args[0]);
  }

  public DOMTest4(String uri) throws Exception {
    DocumentBuilderFactory factory =
    DocumentBuilderFactory.newInstance();
    factory.setValidating(true);
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document doc = builder.parse(uri);
    Element rootElement = doc.getDocumentElement();
    NodeList children = rootElement.getChildNodes();
    Node current = null;
    for (int i = 0; i < children.getLength(); i++) {
        current = children.item(i);
        if (current.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element)current;
          if (element.getTagName().equalsIgnoreCase("tableOfContents")) {
            rootElement.removeChild(element);
          }
        }
      }
      System.out.println(doc.getDocumentElement());
    }
  }
