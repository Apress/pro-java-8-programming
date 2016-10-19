PreparedStatement pstmt;
// …
ParameterMetaData pmd = pstmt.getParameterMetaData();
int count = pmd.getParameterCount();
for (int i = 1; i <= count; i++) {
    System.out.println("Parameter " + i +
            " is associated with a column of type " + pmd.getColumnTypeName(i);
}
