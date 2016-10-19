protected void displayTree(Node node) {
  short nodeType = node.getNodeType();
  switch (nodeType) {
    case Node.DOCUMENT_NODE:
      printDocument((Document)node);
      break;
    case Node.ELEMENT_NODE:
      printElement((Element)node);
      break;
    case Node.TEXT_NODE:
      printText((Text)node);
      break;
    default:
  }
}
