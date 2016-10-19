String userid = "bspell";
String password = "brett";
// Register the driver with DriverManager
new oracle.jdbc.driver.OracleDriver();
// Get a connection
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oraserver:1521:projava ",
    userid, password);
// Create a statement for executing SQL
Statement stmt = conn.createStatement();
// Execute a query / SELECT statement
ResultSet resultSet = stmt.executeQuery("SELECT * FROM TEST_TABLE");
ResultSetMetaData rsmd = resultSet.getMetaData();
// Find out how many columns were returned by the query
int count = rsmd.getColumnCount();
// Loop until all rows have been processed
while (resultSet.next()) {
  // Loop until all columns in current row have been processed
  for (int i = 1; i <= count; i++) {
    // Print out the current value
    System.out.print(resultSet.getObject(i));
    // Put a comma between each value
    if (i < count) {
      System.out.println(",");
    }
  }
  // Start the next row's values on a new line
  System.out.println("");
}
// Close the database objects
resultSet.close();
stmt.close();
conn.close();
