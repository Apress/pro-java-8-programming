// ...
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
     // Create another text node containing a linefeed and
     // two tabs to use for whitespace
     newText = doc.createTextNode("\n\t\t");
     // Insert it before the new <tocEntry> we added
     element.insertBefore(newText, secondChild);
    }
  }
}
// ...
