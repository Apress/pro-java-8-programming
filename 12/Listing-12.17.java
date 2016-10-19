try
(
  Connection conn = DriverManager.getConnection(
      "jdbc:oracle:thin:@oraserver:1521:projava ", userid, password);
  Statement stmt = conn.createStatement();
  ResultSet resultSet = stmt.executeQuery("SELECT * FROM TEST_TABLE");
)
{
  while (resultSet.next()) {
    // Process ResultSet data here
  }
}
