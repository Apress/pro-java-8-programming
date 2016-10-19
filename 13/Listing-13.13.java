ResourceBundle bundle = ResourceBundle.getBundle("FormatMessages");
int userCount;
// …
String myText = (String)(bundle.getObject("CurrentUsers"));
MessageFormat mf = new MessageFormat(myText);
Object[] vals = {new Integer(userCount)};
System.out.println(mf.format(vals));
