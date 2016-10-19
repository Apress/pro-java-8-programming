Student[] students = new Student[50];
java.sql.ResultSet resultSet;
// Perform query
.
.
.
int index = 0;
while (resultSet.next()) {
    students[index++] = createStudent(resultSet);
}
.
.
.
// Creates and returns a Student from data in current row of the ResultSet
private Student createStudent(ResultSet resultSet) throws SQLException {