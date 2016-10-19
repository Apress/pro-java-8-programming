ResourceBundle bundle = ResourceBundle.getBundle("FormatMessages");
float depositAmount = 123.4f;
// …
String msgText = (String)(bundle.getObject("Deposit"));
MessageFormat msgFormat = new MessageFormat(msgText);
DateFormat timeFormat = DateFormat.getTimeInstance(
    DateFormat.LONG, Locale.ITALY);
msgFormat.setFormat(1, timeFormat);
DateFormat dateFormat = DateFormat.getDateInstance(
    DateFormat.LONG, Locale.ITALY);
msgFormat.setFormat(2, dateFormat);
Object[] values = {new Float(depositAmount), new java.util.Date()};
System.out.println(msgFormat.format(values));
