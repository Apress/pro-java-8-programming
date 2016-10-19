import java.text.*;
import java.util.Date;

public class DateTest {

  public static void main(String[] args) throws ParseException {
    DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);
    formatter.setLenient(false);
    Date theDate = formatter.parse(args[0]);
    System.out.println(theDate);
  }
}
