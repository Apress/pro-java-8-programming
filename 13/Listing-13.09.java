ResourceBundle bundle = ResourceBundle.getBundle("FormatMessages");
float depositAmount = 123.4f;
// …
String msgText = (String)(bundle.getObject("Deposit"));
MessageFormat msgFormat = new MessageFormat(msgText);
msgFormat.setLocale(Locale.FRANCE);
msgFormat.applyPattern(msgFormat.toPattern());
Object[] values = {new Float(depositAmount), new java.util.Date()};
System.out.println(msgFormat.format(values));
