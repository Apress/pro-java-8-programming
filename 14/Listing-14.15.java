import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest5 {

  public static void main(String[] args) throws Exception {
    DOMTest5 dt = new DOMTest5(args[0]);
  }

  public DOMTest5(String uri) throws Exception {
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
          // Get the list of <tocEntry> items
          NodeList tocitems = element.getElementsByTagName("tocEntry");
          // Obtain a reference to the second one
          Node secondChild = tocitems.item(1);
          // Create a new <tocEntry> element
          Element newTOCItem = doc.createElement("tocEntry");
          // Create a new "Help" text node
          Text newText = doc.createTextNode("Help");
          // Make it a child of the new <tocEntry> element
          // <tocEntry>Help</tocEntry>
          newTOCItem.appendChild(newText);
          // Add the new <tocEntry> element to <tableOfContents>
          element.insertBefore(newTOCItem, secondChild);
         }
       }
    }

    System.out.println(doc.getDocumentElement());
  }
}
