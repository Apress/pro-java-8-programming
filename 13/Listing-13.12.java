ResourceBundle bundle = ResourceBundle.getBundle("FormatMessages");
int userCount;
// …
//  The ResourceBundle includes a CurrentUsers key that's associated with
//  the message shown below:
//
//      {0} currently logged on.
//
Integer countValue = new Integer(userCount);
String msgText = (String)(bundle.getObject("CurrentUsers"));
double[] borderValues = {0d, 1d, 2d};
String[] descriptions = {"No users are", "One user is", "{0} users are"};
ChoiceFormat choice = new ChoiceFormat(borderValues, descriptions);
Object[] values = {choice.format(countValue)};
MessageFormat msgFormat = new MessageFormat(msgText);
msgFormat.applyPattern(msgFormat.format(values));
values[0] = countValue;
System.out.println(msgFormat.format(values));
