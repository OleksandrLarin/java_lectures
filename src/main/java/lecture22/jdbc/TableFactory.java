package lecture22.jdbc;

public class TableFactory {
    private static final String CREATE_STUDENT_TABLE = "CREATE TABLE IF NOT EXISTS student (student_id SERIAL, " +
            "first_name varchar(55) NOT NULL, " +
            "last_name varchar(55) NOT NULL, " +
            "date_of_birth date " +
            ");";

    public static void createStudentTable(DBConnector dbConnector) {
        dbConnector.executeUpdate(CREATE_STUDENT_TABLE);
    }
}
