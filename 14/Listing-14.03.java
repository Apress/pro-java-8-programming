DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setValidating(true);
DocumentBuilder builder = factory.newDocumentBuilder(); 
Document doc = builder.parse(uri);
Element rootElement = (doc.getDocumentElement());
