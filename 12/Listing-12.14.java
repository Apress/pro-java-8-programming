Connection conn;
Savepoint savepoint = null;
// …
try {
    performFirstUpdate(conn);
    savepoint = conn.setSavepoint();
    performSecondUpdate(conn);
    conn.commit();
}
catch (SQLException sqle) {
    if (savepoint != null) {
        conn.rollback(savepoint);
    }
    else {
        conn.rollback();
    }
}
