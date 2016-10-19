protected void printElement(Element node) {
  Node child;
  Attr attr;
  System.out.print("<" + node.getNodeName());
  NamedNodeMap attrs = node.getAttributes();
  int count = attrs.getLength();
  for (int i = 0; i < count; i++) {
      attr = (Attr)(attrs.item(i));
      System.out.print(" " + attr.getName() + "=\"" + attr.getValue() +
                         "\"");
  }
  System.out.print(">");
  NodeList children = node.getChildNodes();
  count = children.getLength();
  for (int i = 0; i < count; i++) {
      child = children.item(i);
      displayTree(child);
  }
  System.out.print("</" + node.getNodeName() + ">");
}
