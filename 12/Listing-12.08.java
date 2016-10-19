Statement stmt = connect.createStatement();
ResultSet resultSet = stmt.executeQuery(
    "SELECT * FROM NAMETABLE WHERE EMPLOYEE = 123");
if (resultSet.next()) {
   Array sqlArray = resultSet.getArray("NAMECOL");
   ResultSet arraySet = sqlArray.getResultSet();
   while (arraySet.next()) {
     System.out.println(arraySet.getObject(2));
   }
}
