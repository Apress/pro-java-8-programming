protected void printElement(Element node) {
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
  // ...
  System.out.print("</" + node.getNodeName() + ">");
}
