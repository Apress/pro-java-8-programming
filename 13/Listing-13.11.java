ResourceBundle bundle = ResourceBundle.getBundle("FormatMessages");
float depositAmount = 123.4f;
// …
String msgText = (String)(bundle.getObject("Deposit"));
MessageFormat msgFormat = new MessageFormat(msgText);
Format[] formats = msgFormat.getFormats();
formats[1] = DateFormat.getTimeInstance(
    DateFormat.LONG, Locale.ITALY);
formats[2] = DateFormat.getDateInstance(
    DateFormat.LONG, Locale.ITALY);
msgFormat.setFormats(formats);
Object[] values = {new Float(depositAmount), new java.util.Date()};
System.out.println(msgFormat.format(values));
