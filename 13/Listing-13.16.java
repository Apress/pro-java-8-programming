import java.util.Date;

public class Person implements java.io.Serializable {

  private String firstName;
  private String lastName;
  private String address;
  private Date dateOfBirth;

  public Person(String fn, String ln, String addr, Date dob) {
    super();
    setFirstName(fn);
    setLastName(ln);
    setAddress(addr);
    setDateOfBirth(dob);
  }

  public Person() {
    this(null, null, null, null);
  }

  public void setFirstName(String fn) {
    firstName = fn;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String ln) {
    lastName = ln;
  }

  public String getLastName() {
    return lastName;
  }

  public void setAddress(String addr) {
    address = addr;
  }

  public String getAddress() {
    return address;
  }

  public void setDateOfBirth(Date dob) {
    dateOfBirth = dob;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }
}