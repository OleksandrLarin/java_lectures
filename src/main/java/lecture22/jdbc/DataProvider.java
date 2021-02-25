package lecture22.jdbc;

import lecture22.jdbc.model.Student;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataProvider {

    private static final String INSERT_STUDENT = "INSERT INTO student (first_name, last_name, date_of_birth) " +
            "VALUES (?, ?, ?)";


    public static void insertStudent(DBConnector dbConnector, Student student) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_STUDENT);
        try {
            LocalDate studentDay = student.getDateOfBirth();
            Date date = new Date(studentDay.toEpochDay());


            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setDate(3, date);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
