protected void printText(CharacterData node) {
  System.out.print(node.getData());
}

protected void printComment(Comment node) {
  System.out.print("<!--" + node.getData() + "-->");
}

protected void printCDATA(CDATASection node) {
  System.out.print("<![CDATA[" + node.getData() + "]]>");
}

protected void printEntityReference(EntityReference node) {
  System.out.print("&" + node.getNodeName() + ";");
}

protected void printProcessingInstruction(ProcessingInstruction node) {
  System.out.print("<?" + node.getTarget() + " " + node.getData() + "?>");
}
