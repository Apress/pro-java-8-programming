TransformerFactory factory = TransformerFactory.newInstance(); 
File file = new File("C:/brett/temp/styletest.xsl");
Source source = new StreamSource(file);


Transformer transformer = factory.newTransformer(source);
file = new  File("C:/brett/temp/mytest.xml");
source = new  StreamSource(file);
Result result = new StreamResult(System.out);
transformer.transform(source, result);
