String[] names;
Statement stmt = connect.createStatement();
ResultSet resultSet = stmt.executeQuery(
    "SELECT * FROM NAMETABLE WHERE EMPLOYEE = 123");
if (resultSet.next()) {
  Array sqlArray = resultSet.getArray("NAMECOL");
  names = (String[])(sqlArray.getArray());
  for (int i = 0; i < names.length; i++) {
    System.out.println(names[i]);
  }
}
