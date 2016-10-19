import java.sql.*;

public class TransTest {

  private String url = "jdbc:odbc:banktest";
  private String userid = "bspell";
  private String password = "brett";

  public void transferFunds(float transferAmount, int accountNumber,
      String fromTable, String toTable) throws SQLException,
      InvalidTransferException {
    Statement stmt = null;
    ResultSet resultSet = null;
    Connection conn = DriverManager.getConnection(url, userid,
        password);
    try {
      stmt = conn.createStatement();
      resultSet = stmt.executeQuery("SELECT BALANCE FROM " + fromTable +
          " WHERE ACCOUNTID = " + accountNumber);
      resultSet.next();
      float fromBalance = resultSet.getFloat(1);
      if (fromBalance < transferAmount) {
        throw new InvalidTransferException("Insufficient funds available");
      }
      resultSet.close();
      resultSet = stmt.executeQuery("SELECT BALANCE FROM " + toTable +
          " WHERE ACCOUNTID = " + accountNumber);
      resultSet.next();
      float toBalance = resultSet.getFloat(1);
      fromBalance -= transferAmount;
      toBalance += transferAmount;
      stmt.executeUpdate("UPDATE " + fromTable + " SET BALANCE = " +
           fromBalance + " WHERE ACCOUNTID = " + accountNumber);
      stmt.executeUpdate("UPDATE " + toTable + " SET BALANCE = " +
           toBalance + " WHERE ACCOUNTID = " + accountNumber);
      } finally {
        if (resultSet != null) resultSet.close();
        if (stmt != null) stmt.close();
        conn.close();
      }
  }

  class InvalidTransferException extends Exception {

    public InvalidTransferException(String message) {
      super(message);
    }

  }

}
