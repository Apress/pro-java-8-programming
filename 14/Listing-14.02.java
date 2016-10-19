org.w3c.dom.Node parentNode;
org.w3c.dom.NodeList nodeList;
// ...
nodeList = parentNode.getChildNodes();
int count = nodeList.getLength();
for (int i = 0; i < count; i++) {
  node = nodeList.item(i);
  System.out.println(node.toString());
}
