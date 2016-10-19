import java.sql.*;

public class ProxyConnection implements Connection {

  private Connection realConnection;

  public ProxyConnection(Connection connect) {
    realConnection = connect;
  }

  public void clearWarnings() throws SQLException {
    realConnection.clearWarnings();
  }

  public void close() throws SQLException {
    // Don't close the real connection. Return it to the pool
    // manager instead. This example assumes the existence of
    // a class named PoolManager that's responsible for connection
    // pool management.
    PoolManager.connectionClosed(realConnection);
  }

  public void commit() throws SQLException {
    realConnection.commit();
  }

  public Statement createStatement() throws SQLException {
    return realConnection.createStatement();
  }

  // etc.
