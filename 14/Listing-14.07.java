import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest {

  public static void main(String[] args) throws Exception {
    DOMTest dt = new DOMTest(args[0]);
}

public DOMTest(String uri) throws Exception {
  DocumentBuilderFactory factory =
      DocumentBuilderFactory.newInstance();
  factory.setValidating(true);
  DocumentBuilder builder = factory.newDocumentBuilder();
  Document doc = builder.parse(uri);
  displayTree(doc.getDocumentElement());
}

protected void displayTree(Node node) {
  short nodeType = node.getNodeType();
  switch (nodeType) {
    case Node.ELEMENT_NODE:
      printElement((Element)node);
      break;
    case Node.TEXT_NODE:
      printText((Text)node);
      break;
    case Node.COMMENT_NODE:
      printComment((Comment)node);
      break;
    case Node.CDATA_SECTION_NODE:
      printCDATA((CDATASection)node);
     break;
    case Node.ENTITY_REFERENCE_NODE:
      printEntityReference((EntityReference)node);
     break;
    case Node.PROCESSING_INSTRUCTION_NODE:
      printProcessingInstruction(
          (ProcessingInstruction)node);
      break;
    default:
  }
}

protected void printElement(Element node) {
  // ...
}

protected void printText(CharacterData node) {
  // ...
}

protected void printComment(Comment node) {
  // ...
}

protected void printCDATA(CDATASection node) {
  // ...
}

protected void printEntityReference(EntityReference node) {
  // ...
}

protected void printProcessingInstruction(ProcessingInstruction node) {
  // ...
}
}
