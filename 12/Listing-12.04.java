Connection connect = null;
String procedureCall = "{?= call myProcedure(?, ?, ?)}";
CallableStatement cstmt = connect.prepareCall(procedureCall);
cstmt.setString(2, "Hello");
cstmt.setInt(3, 123);
cstmt.setBoolean(4, true);
cstmt.registerOutParameter(1, Types.NUMERIC);
cstmt.registerOutParameter(3, Types.VARCHAR);
