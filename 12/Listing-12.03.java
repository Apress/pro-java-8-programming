PreparedStatement pstmt = connect.prepareStatement(
    "UPDATE MYTABLE SET FNAME = ? WHERE CUSTID = ?");

pstmt.setString(1, "Jacob");
pstmt.setInt(2, 123);
pstmt.executeUpdate();

pstmt.setString(1, "Jordan");
pstmt.setInt(2, 456);
pstmt.executeUpdate();

pstmt.setString(1, "Jeffery");
pstmt.setInt(2, 789);
pstmt.executeUpdate();
