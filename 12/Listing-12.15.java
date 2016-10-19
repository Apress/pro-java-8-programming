String url = "jdbc:oracle:thin:@myserver:1521:mydata";
String userid = "bspell";
String password = "brett";
OracleConnectionPoolDataSource ocpds = new OracleConnectionPoolDataSource();
ocpds.setURL(url);
ocpds.setUser(userid);
ocpds.setPassword(password);
PooledConnection pool = ocpds.getPooledConnection();
// . . .
Connection conn = pool.getConnection();
