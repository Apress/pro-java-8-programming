int recordCount;
Statement stmt = connect.createStatement();
// Get the data
ResultSet resultSet = stmt.executeQuery(
    "SELECT COUNT(*) FROM EMPLOYEE WHERE SALARY < 50000");
// Move the cursor to the last row 
resultSet.last();
// Get the current row's index (i.e., the number of rows in the ResultSet)
recordCount = resultSet.getRow();
// Restore the cursor to its previous position 
resultSet.beforeFirst();
