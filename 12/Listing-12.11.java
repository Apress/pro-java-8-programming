public void printResultSet(ResultSet resultSet) throws SQLException {
  ResultSetMetaData rsmd = resultSet.getMetaData();
  int count = rsmd.getColumnCount();
  for (int i = 0; i < count; i++) {
    System.out.print((i == 0 ? "" : "\t") +
    rsmd.getColumnName(i + 1));
  }
  System.out.println();
  while (resultSet.next()) {
    for (int i = 0; i < count; i++) {
    System.out.print((i == 0 ? "" : "\t") +
    resultSet.getObject(i + 1));
  }
  System.out.println();
 }
}
